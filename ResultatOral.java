package TPRevision;

public class ResultatOral implements Resultat {
	private char appreciation;
	
	public ResultatOral(char appreciation) {
		if (appreciation!= 'A' || appreciation!= 'B'|| appreciation!= 'C' ) {
			throw new IllegalArgumentException ("Appreciation invalide!"); 
		}
		else {
		this.appreciation = appreciation;
		}
	}
	@Override
	public String toString() {
		return "ResultatOral [appreciation=" + appreciation + "]";
	}

	@Override
	public int compareTo(Resultat r) {
		// TODO Auto-generated method stub
		int res=0;
		if (!(r instanceof ResultatOral)) {
			throw new IllegalArgumentException ("Les resultats doive,t etre de meme nature!");
		}
		else {
			if (this.appreciation==((ResultatOral)r).appreciation) {
				res=0;
			}
			else {
				if (this.appreciation>((ResultatOral)(r)).appreciation) {
					res=1;
				}
				else {
					res=-1;
				}
			}
			
		}
		return res;
	}
	

}
