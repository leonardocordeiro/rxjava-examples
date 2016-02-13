package cap2;

import java.util.Arrays;
import java.util.List;

import rx.Observable;

public class UsandoOutrosOperadores {

	public static void main(String[] args) {
		
		// Take emite somente os x itens especificados
		Observable.just(Arrays.asList("1", "2", "3"))
			.flatMap(urls -> Observable.from(urls))
			.take(2)
			.subscribe(System.out::println);
		
		System.out.println();
		
		// Filter
		Observable.just(Arrays.asList("1", null, "2", "3"))
		.flatMap(urls -> Observable.from(urls))
		.take(2)
		.filter(url -> url != null)
		.subscribe(System.out::println);
		
		System.out.println();
		
		// Filter
		Observable.just(Arrays.asList("1", "Zeca", "2", "3"))
		.flatMap(urls -> Observable.from(urls))
		.take(2)
		.doOnNext(url -> System.out.println("Fazendo algo no meio com a: " + url))
		.subscribe(System.out::println);
		
		
		
	}

	public static Observable<String> getTitle(String url) {
		return Observable.just("Leonardo");
	}
	
	public static List<String> getUrls() {
		return Arrays.asList("1", "2", "3");
	}
}
