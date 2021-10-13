import java.util.Comparator;
import java.util.Objects;

public class Mesada {

	private Integer largo, ancho;

	public Mesada() {
	}

	public Mesada(Integer largo, Integer ancho) {
		this.largo = largo;
		this.ancho = ancho;
	}

	public int getLargo() {
		return largo;
	}

	public int getAncho() {
		return ancho;
	}

	public void setLargo(Integer largo) {
		this.largo = largo;
	}

	public void setAncho(Integer ancho) {
		this.ancho = ancho;
	}

	@Override
	public String toString() {
		return "Mesada [largo=" + largo + ", ancho=" + ancho + "]";
	}

	public int compareTo(Mesada m1, Mesada m2) {
		return Comparators.LARGOYANCHO.compare(m1, m2);
	}

	public static class Comparators {

		public static Comparator<Mesada> LARGOYANCHO = new Comparator<Mesada>() {
			@Override
			public int compare(Mesada m1, Mesada m2) {

				int i = m1.largo.compareTo(m2.largo);
				if (i == 0) {
					i = m1.ancho - m2.ancho;
				}

				return i;
			}
		};
	}

	@Override
	public int hashCode() {
		return Objects.hash(largo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mesada other = (Mesada) obj;
		return Objects.equals(largo, other.largo);
	}

}
