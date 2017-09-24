package careercup;

/**
	Seeding rules used in NBA, tennis
	maxSeed = 2*k;
	Input: 8
	Output: (((1,8),(4,5)),((2,7),(3,6)))
**/
public class OutputContest{

	public static void main(String[] args){
		
		int maxSeed =8;
		OutputContest obj = new OutputContest();
		System.out.println("Total seeds: "+ maxSeed+ "\t Pairs: " + obj.generateSeededPairs(maxSeed));
	
		maxSeed = 4;
		System.out.println("Total seeds: "+ maxSeed + "\t Pairs: " + obj.generateSeededPairs(maxSeed));
	}

	public String generateSeededPairs(int maxSeed){
		
		StringBuilder[] seedPairBuffer = new StringBuilder[maxSeed];
		for(int i=0; i<maxSeed; i++){
			seedPairBuffer[i] = new StringBuilder(String.valueOf(i+1));
		}

		while(maxSeed > 0){
			for(int i=0; i< maxSeed/2; i++){
				seedPairBuffer[i] = seedPairBuffer[i].insert(0, "(").append(",").append(seedPairBuffer[maxSeed-i-1]).append(")");
			}
			maxSeed /= 2;
		}
		return seedPairBuffer[0].toString();
	}


}
