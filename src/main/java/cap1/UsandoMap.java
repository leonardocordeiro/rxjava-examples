package cap1;

import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Subscriber;
import rx.functions.Action1;


public class UsandoMap {
	public static void main(String[] args) {
		
		Observable<Object> observable = Observable.just("Leonardo Cordeiro")
		
		// Quero transformar e devolver hashCode
		
		// Recebo String e devolvo Integer (por isso Observable de Object)
		.map(s -> s + " - Lindão!");
		
		observable.subscribe(System.out::println);
		
	}
}
