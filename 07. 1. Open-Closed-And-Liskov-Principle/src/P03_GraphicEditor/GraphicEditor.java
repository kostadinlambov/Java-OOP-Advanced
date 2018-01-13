package P03_GraphicEditor;

public class GraphicEditor {

    static void test(Drawable drawable) {
        drawable.draw();
    }

    public static void main(String[] args) {
        Drawable rectangle = new Rectangle();
        Drawable circle = new Circle();
        Drawable square = new Square();
        GraphicEditor.test(rectangle);
        GraphicEditor.test(circle);
        GraphicEditor.test(square);
    }
}
