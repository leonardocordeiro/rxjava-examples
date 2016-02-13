package cap2;

import java.util.Arrays;
import java.util.List;

import rx.Observable;

public class JustVsFrom {

	public static void main(String[] args) {
		// Just vai emitir a propria lista
		Observable.just(Arrays.asList("1", "2", "3"))
			.subscribe(System.out::println);
		
		// From emite cada item da lista
		Observable.from(Arrays.asList("1", "2", "3"))
			.subscribe(System.out::println);
		
	}

	public static Observable<String> getTitle(String url) {
		return Observable.just("Leonardo");
	}
	
	public static List<String> getUrls() {
		return Arrays.asList("1", "2", "3");
	}
}
