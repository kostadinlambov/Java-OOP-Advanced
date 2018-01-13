package P05_Square;

class Rectangle {
    private int m_width;
    private int m_height;

    Rectangle(int width, int m_height) {
        this.m_width = width;
        this.m_height = m_height;
    }


    public int getWidth() {
        return this.m_width;
    }

    public int getHeight() {
        return this.m_height;
    }

    public int getArea() {
        return this.m_width * this.m_height;
    }
}
