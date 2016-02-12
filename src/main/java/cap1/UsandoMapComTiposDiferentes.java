package cap1;

import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Subscriber;


public class UsandoMapComTiposDiferentes {
	public static void main(String[] args) {
		
		Observable<Object> observable = Observable.just("Leonardo Cordeiro")
		
		// Quero transformar e devolver hashCode
		
		// Recebo String e devolvo Integer (por isso Observable de Object)
		.map(s -> s.hashCode())
		.map(i -> "Nome em HashCode: " + i);
		
		observable.subscribe(System.out::println);
		
	}
}
