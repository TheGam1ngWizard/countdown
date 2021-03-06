package countdown;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class NumberBag extends bag{

	private List<Integer> smallbag = new ArrayList<Integer>();
	private List<Integer> bigbag = new ArrayList<Integer>();
	
	@Override
	public void fillNumbers(String bag, List<Integer> numbers) { //closed for modification, not hardset weights- assignable at program run.
		if(bag == "small") {
			smallbag.removeAll(smallbag);
			smallbag.addAll(numbers);
		}
		else if(bag == "big") {
			bigbag.removeAll(bigbag);
			bigbag.addAll(numbers);
		}
	}



	public int drawNumber(String bag) {
		int upperSmallRange = smallbag.size();
		int upperBigRange = bigbag.size();
		Integer number = null;
		if(bag == "small") {
			number = smallbag.get(ThreadLocalRandom.current().nextInt(1, upperSmallRange));
			smallbag.remove(number);
			}
		if(bag == "big") {
			number = bigbag.get(ThreadLocalRandom.current().nextInt(1, upperBigRange));
			bigbag.remove(number);
		}
		return number;
	}

	/*public void EmptyBags(String bag) {
		smallbag.removeAll(smallbag);
		bigbag.removeAll(bigbag);
	}
	*/
	@Override
	public int BagSize(String bag) {
		int bagsize = 0;
		if(bag == "small") {
			bagsize = smallbag.size();
		}
		else if(bag == "big") {
			bagsize = bigbag.size();
		}
		return bagsize;
	}
}
