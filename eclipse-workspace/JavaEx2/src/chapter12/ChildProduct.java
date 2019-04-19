package chapter12;

public class ChildProduct<T, V, C> extends Product<T, V> {
	   private C company;
	   public C getCompany() { return this.company; }
	   public void setCompany(C company) { this.company = company; }
}
