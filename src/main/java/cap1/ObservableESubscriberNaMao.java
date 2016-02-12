package cap1;

import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Subscriber;


public class ObservableESubscriberNaMao {
	public static void main(String[] args) {
		
		Observable<String> observable = Observable.create(new OnSubscribe<String>() {

			@Override
			public void call(Subscriber<? super String> subscriber) {
				subscriber.onNext("Nome: Leonardo Cordeiro");
				subscriber.onCompleted();
			}
		});
		
		observable.subscribe(new Subscriber<String>() {

			@Override
			public void onCompleted() {
			}

			@Override
			public void onError(Throwable arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onNext(String arg0) {
				System.out.println(arg0);
			}
		});
		
	}
}
