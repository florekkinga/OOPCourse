import static java.lang.Integer.max;

public class Choinka {
    double wysokosc;
    String gatunek;

    Choinka(double wysokosc, String gatunek) {
        this.wysokosc = wysokosc;
        this.gatunek = gatunek;
    }

    Choinka[][] sort(Choinka[] arr) {

        int max;
        int sosna = 0, jodla = 0, swierk = 0;
        for (Choinka choinka : arr) {
            switch (choinka.gatunek) {
                case "sosna": {
                    sosna++;
                    break;
                }
                case "jodla": {
                    jodla++;
                    break;
                }
                case "swierk": {
                    swierk++;
                    break;
                }
            }
        }
        max = max(max(sosna, jodla), swierk);


        Choinka[][] arr2d = new Choinka[max][3];
        int currjodla = 0, currswierk = 0, currsosna = 0;
        Choinka [] jodly = new Choinka[jodla];
        Choinka [] swierki = new Choinka[swierk];
        Choinka [] sosny = new Choinka[sosna];
        for (int i = 0; i < arr.length; i++) {
                switch (arr[i].gatunek) {
                    case "jodla":
                        jodly[currjodla] = arr[i];
                        currjodla++;
                        break;
                    case "swierk":
                        swierki[currswierk] = arr[i];
                        currswierk++;
                        break;
                    case "sosna":
                        sosny[currsosna] = arr[i];
                        currsosna++;
                        break;
                }
        }

        bubbleSort(jodly);
        bubbleSort(swierki);
        bubbleSort(sosny);

        for(int i=0; i<jodla; i++){
            arr2d[i][0]=jodly[i];
        }
        for(int i=0; i<swierk; i++){
            arr2d[i][1]=swierki[i];
        }
        for(int i=0; i<sosna; i++) {
            arr2d[i][2] = sosny[i];
        }
        StringBuilder buf = new StringBuilder();
        for(int i=0;i<max;i++){
            buf.append("[");
            for(int j=0; j<3; j++){
                if (j==3-1) buf.append(arr2d[i][j]);
                else{
                    buf.append(arr2d[i][j]);
                    buf.append(", ");
                }
            }
            if (i==max-1) buf.append("]");
            else{
                buf.append("]\n");
            }
        }
        System.out.println(buf);

        return arr2d;
    }

    void bubbleSort(Choinka[] arr) {
        int n = arr.length;
        for (int col = 0; col < 3; col++) {
            for (int i = 0; i < n - 1; i++)
                for (int j = 0; j < n - i - 1; j++)
                    if (arr[j].wysokosc > arr[j + 1].wysokosc) {
                        Choinka temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
        }
        for(Choinka choinka : arr){
            System.out.print(choinka.wysokosc);
            System.out.println(choinka.gatunek);
        }
    }

    public static void main(String args[]){
        Choinka instance0 = new Choinka(143.25, "jodla");
        Choinka instance1 = new Choinka(130.25, "jodla");
        Choinka instance2 = new Choinka(150.25, "jodla");
        Choinka instance3 = new Choinka(100.25, "swierk");
        Choinka instance4 = new Choinka(180.25, "swierk");
        Choinka instance5 = new Choinka(140.25, "sosna");
        Choinka [][] expResult = new Choinka[][]{{instance1,instance0,instance2},{instance3, instance4},{instance5}};
        Choinka [] list = {instance0,instance1,instance2,instance3,instance4,instance5};
        instance0.sort(list);
        StringBuilder buf = new StringBuilder();

        int n =3;
        for(int i=0; i<n; i++){
            buf.append("[");
            for(int j=0; j<3; j++){
                if (j==3-1) buf.append(expResult[i][j]);
                else{
                    buf.append(expResult[i][j]);
                    buf.append(", ");
                }
            }
            if (i==2) buf.append("]");
            else{
                buf.append("]\n");
            }
        }
        System.out.println(buf);
    }

}

