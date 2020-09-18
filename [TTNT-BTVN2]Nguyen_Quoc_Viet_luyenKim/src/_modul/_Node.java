package _modul;

public class _Node {

    private String name;
    private _2D toaDo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public _2D getToaDo() {
        return toaDo;
    }

    public void setToaDo(_2D toaDo) {
        this.toaDo = toaDo;
    }

    public _Node() {
        name = "NULL";
        toaDo = new _2D();
    }

    public _Node(String name, _2D toaDo) {
        this.name = name;
        this.toaDo = toaDo;
    }

    public void scanNode() {
        name = io.ScanStr("Nhập tên đỉnh");
        toaDo.setX(io.ScanInt("Nhập tọa độ x"));
        toaDo.setY(io.ScanInt("Nhập tọa độ y"));
    }

    public void showNode() {
        System.out.println("[ " + name + ": " + toaDo.show() + " ]");
    }
}
