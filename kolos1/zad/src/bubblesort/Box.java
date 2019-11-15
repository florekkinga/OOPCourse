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

    Box[] bubbleSort(Box[] arr)
    {
        int n = arr.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (arr[j].volume() > arr[j+1].volume())
                {
                    Box temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
        return arr;
    }

}
