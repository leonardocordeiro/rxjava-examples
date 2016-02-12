package extra;

import rx.Observable;

public class ExemploComDeferVsJust {
	
	static String nome = "Leonardo Cordeiro";
	
	public static void main(String[] args) {
		
		/** Documentacao
		 * defer( ) — do not create the Observable until a Subscriber subscribes; 
		 * create a fresh Observable on each subscription
		 * 
		 * just( ) — convert an object or several objects into an Observable
		 * that emits that object or those objects
		 *
		 */
		
		/** IMPORTANTE!!
		 * just: cria o Observable recebendo o valor do Subscriber.onNext
		 * defer: recebe uma funcao que cria um Observable será chamada no momento da inscricao.
		 *  
		 * Como o defer irá postergar a cricao do Observable pro momento da inscricao,
		 * ele criará um Observable por inscricao. Ao contrario de usar apenas o just
		 * que cria apenas um aproveitando o mesmo para todas as inscricoes
		 */
		
		// O Observable é criado neste momento (just) com o valor que recebemos no just
		// Ou seja, ele salvará e emitirá o valor Leonardo Cordeiro
		Observable<String> observable = Observable.just(nome);
		
		// Neste momento mudamos o valor para Aline
		nome = "Aline";

		// Como o Observable salvou o valor Leonardo Cordeiro no momento da criacao 
		// ele irá emitir Aline
		observable.subscribe(System.out::println);
		
		// Mudamos para o valor que tinhamos no inicio
		nome = "Leonardo Cordeiro";
		
		// Nesse momento estamos usando o defer para postergar a criacao do Observable 
		// para somente quando houver inscricao. Ou seja, nesse momento o valor é Leonardo
		Observable<String> observableComDefer = Observable.defer(() -> Observable.just(nome));
		
		// Mudamos o valor para Aline
		nome = "Aline";
		
		// Como a criacao do Observable foi postergada (defer) ele irá criá-lo AGORA. 
		// Nesse momento, o valor que o just receberá será Aline
		observableComDefer.subscribe(System.out::println);
		
		// Outro exemplo
		
		// Chamará o metodo getNome agora, já que o Observable está sendo criado agora
		// Chamará getNome printando no console "Chamou"
		Observable<String> observable2 = Observable.just(getNome());
		
		// O defer posterga a execucao do codigo pro momento da subscricao. 
		//Por isso, postergamos a criacao do Observable pro momento da inscricao! 
		//getNome nao sera chamado!
		Observable<String> observable2ComDefer = Observable.defer(() -> Observable.just(getNome()));
		
		// Descomentar essa linha o Observable será criado nesse momento (inscricao) 
		//e getNome será chamado
		
		// observable2ComDefer.subscribe(System.out::println);
		
	}

	private static String getNome() {
		System.out.println("Chamou");
		return "Leonardo";
	}
}
