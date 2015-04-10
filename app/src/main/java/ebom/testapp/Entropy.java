package ebom.testapp;

import java.util.*;
import android.util.Log;

public class Entropy {
	Hashtable entropy = new Hashtable();
    Hashtable counter = new Hashtable();
    List<String> clickStream = new ArrayList<String>();
    Enumeration key, countKey;
	String str, str2;
    int temp;
	double entr;
	

    public void create(String[] clicks){

        for(int i = 0; i < clicks.length; i++) {
            if (entropy.containsKey(clicks[i])) {
                continue;
            } else {
                entropy.put(clicks[i], new Double(0.0));
            }
        }
        for(int i = 0; i < clicks.length; i++) {
            if(counter.containsKey(clicks[i])){
                continue;
            }
            else {
                counter.put(clicks[i], new Integer(0));
            }
        }
    }

    public void click(String choice){
        clickStream.add(choice);
        for (int i = 0; i < clickStream.size(); i++){
            Log.d("MyTag", clickStream.get(i));
        }
    }
	public void clearCount(){
        countKey = counter.keys();
        while(countKey.hasMoreElements()){
            str = (String) countKey.nextElement();
            counter.put(str, new Integer(0));
        }
    }


	//Counts through the array and records in the counter array the amount for each element. 
	public void count (){
		countKey = counter.keys();
        while(countKey.hasMoreElements()){
            str = (String) countKey.nextElement();
            counter.put(str, new Integer(0));
        }
        String[] clickStr = new String[clickStream.size()];
        clickStr = clickStream.toArray(clickStr);
		key = entropy.keys();
		while(key.hasMoreElements()){
			str = (String) key.nextElement();
			for(int i = 0; i<clickStr.length; i++){
				if(str == clickStr[i]){
                    temp = ((Integer)counter.get(str)).intValue();
					counter.put(str, new Integer(temp + 1));
				}
			}
		}

	}
	
	//Does the entropy calculation and stores it to the hashtable locations
	public void calcEntropy(){
        int total = clickStream.size();
		key = entropy.keys();
		while(key.hasMoreElements()){
			str = (String) key.nextElement();
			temp = ((Integer)counter.get(str)).intValue();

			double prob = (double)temp/(double)total;
			entr = ((Double)entropy.get(str)).doubleValue();
			if(temp == 0){
				entropy.put(str, new Double(entr + 0));
			}
			else{
				entr = entr + -(prob * Math.log10(prob));
				entropy.put(str, new Double(entr));	
			}
		}
	}
	
	//Displays All Entropy Values 
	public void displayAll(){
		key = entropy.keys();
		while(key.hasMoreElements()){
			str = (String) key.nextElement();
			System.out.println(str + ": "+ entropy.get(str));
		}
		System.out.println();
		return;
	}

    //Displays A Specific Entropy Value
    public double displayOne(String choice){
        key = entropy.keys();
        while(key.hasMoreElements()){
            str = (String) key.nextElement();
            if(str == choice){
                System.out.println(str + ": " + entropy.get(str));
                entr = ((Double)entropy.get(str)).doubleValue();
                return entr;
            }
        }
        System.out.println("Could not find "+ choice+".");
        return 0.0;
    }

    public int displayCount(String choice){
        countKey = counter.keys();
        while(countKey.hasMoreElements()){
            str2 = (String) countKey.nextElement();
            if(str2 == choice){
                temp = ((Integer)counter.get(str2)).intValue();
                return temp;
            }
        }
        return 0;
    }

}
