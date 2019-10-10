class Memento {
  private int _x, _y, _width, _height;
  private Shape _shape;

  public Memento() {

  }

  public Memento(Shape shape) {
    this._shape = shape;
    this._x = shape.getX();
    this._y = shape.getY();
    this._width = shape.getWidth();
    this._height = shape.getHeight();
  }

  public void restore() {
    this._shape.setLocation(this._x, this._y);
    this._shape.setSize(this._width, this._height);
  }

  public Shape getShape() {
    return this._shape;
  }


  public String toString() {
    return "Move: Shape(" + this.getShape().getId() + ")";
  }
}