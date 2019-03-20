package blastGUI;

public class call {
//	private static final String dataBaseFile = new String("yeast.aa");
//	private static final String dataBaseIndexes = new String("yeast.aa.indexs");
//	
//	public static void main(String args[]){
//		BlastController bCnt = new BlastController();
//		try{
//			String result = bCnt.blastQuery('p', dataBaseFile, 
//					dataBaseIndexes, (float) 0.9, "GKGKGKGKGK");
//			System.out.println(result);
//		} catch(Exception exc){
//			System.out.println("Error en la llamada: " + exc.toString());
//		}
//	} 
	public static void main(String args[]){

		blastGui blastwindow=new blastGui();
		blastwindow.setTitle("BLAST_query");
	}
}
