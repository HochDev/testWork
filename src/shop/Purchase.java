package shop;

public class Purchase {

    private int idUser;
    private int idProduct;

    public Purchase(int idUser, int idProduct) {

        this.idUser = idUser;
        this.idProduct = idProduct;

    }

    public int getIdUser() {
        return idUser;
    }

    public int getIdProduct() {
        return idProduct;
    }
}
