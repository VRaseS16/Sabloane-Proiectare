public class ImageProxy implements Element {
	
	@Override
	public Element copy() {
		ImageProxy newImage = new ImageProxy(this.value);
		newImage.oldValue = this.oldValue;
		return newImage;
	}

	public String value;
	public String oldValue;
	@Override
	public void SetNewValue(String newValue) {
		oldValue = value;
		value = newValue;
		
	}

	public Image realImage;
	
	ImageProxy(String imageName){
		this.value = imageName;
	}
	
	@Override
	public void print() {
		if(realImage == null) {
			realImage = new Image(value);
		}
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toString() {
		return "ImageProxy [imageName=" + value + ", realImage=" + realImage + "]";
	}
	
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}