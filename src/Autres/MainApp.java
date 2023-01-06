package Autres;

public class MainApp {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/guestmanager";
        String user = "root";
        String password = "";

        Products products = new Products();
        products.setName("Bach");

        ProductDAO productDAO = new ProductDAO(url,user,password);

        productDAO.saveProduct(products);

    }
}
