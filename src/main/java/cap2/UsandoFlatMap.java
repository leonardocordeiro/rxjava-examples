package cap2;

import java.util.Arrays;
import java.util.List;

import rx.Observable;

public class UsandoFlatMap {

	public static void main(String[] args) {
		// Vou dividir a lista em urls separadas com o from. Mas pra consumir essas urls
		// precisarei fazer um subscribe interno. Callback hell
		Observable.just(Arrays.asList("1", "2", "3"))
			.subscribe(urls -> Observable.from(urls)
								.subscribe(System.out::println));
		
		// Flatmap transforma a emissao de um Observable (URLS) na emissao de outro Observable
		// (Observable.from(urls). Recebe a lista de URLS e devolve a emissao do Observable.from
		// que sao as URLS separadas
		Observable.just(Arrays.asList("1", "2", "3"))
		.flatMap(urls -> Observable.from(urls))
		.subscribe(System.out::println);
		
		// no primeiro flatMap recebo a lista e devolvo as urls individuais 
		// (o resultado do from(urls)
		// no segundo flatMap recebo uma URL e devolvo a String com o titulo. Já que getTitle
		// devolve um observer e flatMap emite o item de um observador
	
		Observable.just(Arrays.asList("1", "2", "3"))
		.flatMap(urls -> Observable.from(urls))
		.flatMap(url -> getTitle(url))
		.subscribe(System.out::println);
		
		/**
		 * Isso melhora o encapsulamento pois o usuario acha no fim das contas que ta
		 * trabalhando com um Observer<String> nao sabendo o que aconteceu no meio e se tem
		 * alguma operacao acontecendo (doOnNext por ex)
		 * 
		 * Plus, think about how simple our data was to consume once transformed.
		 * By the end of our example we were doing two API calls, manipulating the data, 
		 * then saving it to disk. But our Subscriber doesn't know that; it just thinks it's 
		 * consuming a simple Observable<String>. Encapsulation makes coding easier!
		 */
		
	}

	public static Observable<String> getTitle(String url) {
		return Observable.just("Leonardo");
	}
	
	public static List<String> getUrls() {
		return Arrays.asList("1", "2", "3");
	}
}
