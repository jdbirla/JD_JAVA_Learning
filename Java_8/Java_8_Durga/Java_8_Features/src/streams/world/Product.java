package streams.world;

public class Product {

	  private int id;
	    private String name;
	    private int price;

	    public Product(int id, String name, int price)
	    {
	        super();
	        this.id = id;
	        this.name = name;
	        this.price = price;
	    }

	    public int getId()
	    {
	        return id;
	    }

	    public void setId(int id)
	    {
	        this.id = id;
	    }

	    public String getName()
	    {
	        return name;
	    }

	    public void setName(String name)
	    {
	        this.name = name;
	    }

	    public int getPrice()
	    {
	        return price;
	    }

	    public void setPrice(int price)
	    {
	        this.price = price;
	    }

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Product [id=");
			builder.append(id);
			builder.append(", name=");
			builder.append(name);
			builder.append(", price=");
			builder.append(price);
			builder.append("]");
			return builder.toString();
		}
	    
}
