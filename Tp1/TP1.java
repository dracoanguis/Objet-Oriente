class TP1 {

	static double moyenne(double[] arrIn,int n){
		double sum = 0;
		for (char i = 0; i<arrIn.length; i++){
			sum += arrIn[i];
		}

		return (sum/n);
	}

	static double ecart(double[] arrIn, int n){
		double sum = 0;
		double moy = moyenne(arrIn,arrIn.length);
		for (char i = 0; i<arrIn.length; i++){
			sum += Math.pow(arrIn[i]-moy,2);
		}

		return Math.sqrt(sum/n);
	}

	private static int partition(double arr[], int begin, int end) {
		double pivot = arr[end];
		int i = (begin-1);

		for (int j = begin; j < end; j++) {
			if (arr[j] <= pivot) {
				i++;
				double swapTemp = arr[i];
				arr[i] = arr[j];
				arr[j] = swapTemp;
			}
		}

		double swapTemp = arr[i+1];
		arr[i+1] = arr[end];
		arr[end] = swapTemp;

		return i+1;
	}

	static void quicksort(double[] arrIn, int begin, int end){
		if (begin<end){
			int partitionIndex = partition(arrIn, begin, end);
			quicksort(arrIn, begin, partitionIndex-1);
			quicksort(arrIn, partitionIndex+1, end);
		}
	}

	static double mediane(double[] arrIn, int n){
		double[] arrSor = new double[arrIn.length];
		for (int i = 0; i<arrIn.length; i++){
			arrSor[i]  = arrIn[i];
		}
		quicksort(arrSor,0,arrSor.length-1);
		int pos = (int)Math.ceil(n/2);
		return arrSor[pos];
	}

	public static void main(String[] args) {

		////////////////////////////////// code fourni //////////////////////////////
		//Pour simplifier on considere que les arguments seront tous des double,
		//i.e., notes entre 1.0 et 6.0 (pas de gestion des exceptions)

		//la longeur du tableau args est stockee dans la champ length de args,
		//que vous pouvez pour l'instant simplement considerer comme une variable
		// qui est automatiquement initialisee par la JVM lors du runtime et dont
		//on accede avec la notation args.length (notation object)
		int n = args.length;

		double[] notes = new double[n];

		//convertir  tableau de Strings en tableau de double
		System.out.println("Notes:");
		notes = TP1Utils.str2double(args,n);

		//affichage des notes passees en arguments en ligne de commande
		TP1Utils.dispArr(notes, n);
		//////////////////////////////////////////////////////////////////////////////

		System.out.println("Moyenne: " + moyenne(notes,notes.length));
		System.out.printf("Ecart: %f\n", ecart(notes,notes.length));
		System.out.printf("Mediane: %f\n", mediane(notes,notes.length));
    }
}
