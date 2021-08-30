package pancicaleksa;

import java.util.ArrayList;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;


public class MainClass {
private static final Logger logger = 
	Logger.getLogger(MainClass.class.getName());
public static void main(String[] args) {
	//logger podesavanje
	Handler handler1 = new ConsoleHandler();
	logger.addHandler(handler1);
	logger.setUseParentHandlers(false); //iskljucuje parent handler
	handler1.setFormatter(new MyFormat());
	
	
	NiceNumber SquareNice = (int n) -> {
		for(int i = 1; i < n; i++) {
			for(int j = 1; j < n; j++) {
				if(i*i + j*j == n) {
					return true;
				}
			}
		}
		return false;
	};
	
	NiceNumber DigitNice = (int n) -> {
		int prom = n;
		int cif;
		while(prom != 0) {
			cif = prom % 10;
			prom = prom / 10;
			if(cif == 7) {
				return true;
			}
		}
		return false;
	};
	System.out.println(SquareNice.isNice(5));
	System.out.println(DigitNice.isNice(123));
	ArrayList<Integer> niz = new ArrayList<Integer>();
	int p = 180;
	for(int i = 0; i < p; i++) {
		niz.add(i); //dodaj od 0 do 179 za test
	}
	niz.parallelStream()
	.filter(DigitNice::isNice)
	.forEach(v -> System.out.println(v));
	niz.parallelStream()
	.filter(SquareNice::isNice)
	.forEach(v -> System.out.println(v));
	niz.parallelStream()
	.filter(DigitNice::isNice)
	.filter(SquareNice::isNice)
	.forEach(v -> logger.info("Ekstra lep " + v));
	
}
}
