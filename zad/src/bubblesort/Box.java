package bubblesort;

public class Box {
    float height;
    float width;
    float length;

    Box(float height, float width, float length){
        this.height = height;
        this.width = width;
        this.length = length;
    }

    float volume(){
        return height*width*length;
    }




}
