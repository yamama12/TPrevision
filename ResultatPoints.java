package TPRevision;

public class ResultatPoints implements Resultat{
	private int nbPoints;
	
	public ResultatPoints(int nbPoints) {
		this.nbPoints = nbPoints;
	}

	@Override
	public String toString() {
		return "ResultatPoints [nbPoints=" + nbPoints + "]";
	}

	@Override
	public int compareTo(Resultat r) {
		// TODO Auto-generated method stub
		int res=0;
		if (!(r instanceof ResultatPoints)) {
			throw new IllegalArgumentException("Les résultats ne sont pas de même nature.");
		}
		else {
			if (this.nbPoints==((ResultatPoints)(r)).nbPoints){
				res=0;
			}
			else {
				if (this.nbPoints>((ResultatPoints)(r)).nbPoints) {
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
