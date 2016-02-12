package cap1;

import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Subscriber;
import rx.functions.Action1;


public class UsandoMap {
	public static void main(String[] args) {
		
		// Não precisamos nos preocupar em chamar onNext e onCompleted. No Just passamos 
		// o que gostariamos de passar no onNext do Subscriber
		
		Observable<String> observable = Observable.just("Leonado Cordeiro");
		
		// Subscribe recebe 3 actions (onNext, onError e onCompleted)
		observable.subscribe(new Action1<String>() {

			@Override
			public void call(String nome) {
				System.out.println("Nome: " + nome);
			} 
			
		});
		
		// Com Java 8
		observable.subscribe(System.out::println);
		
	}
}
