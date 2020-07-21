package dong_neee;

import javax.crypto.NullCipher;
import java.util.LinkedList;

import static java.lang.Math.pow;

class dathuc {
    // mot da thuc la danh sach cac hang tu:
    LinkedList<hangtu> dt = new LinkedList<hangtu>();


    dathuc(){}

    dathuc( hangtu a) {
        dt.add(a);
    }


    //Cong hang tu vao da thuc:
    void congHangTu( hangtu a){
        dt.add(a);
        xuliDaThuc();
    }

    //Nhan 1 hang tu vao da thuc:
    void nhanHangTu( hangtu a){
        for(int i=0; i<dt.size(); i++){
            hangtu b = new hangtu( dt.get(i).getSoMu()*a.getSoMu(), dt.get(i).getHeSo()*a.getHeSo());
            dt.set(i,b);
        }
    }

    //xu ly da thuc:
    void xuliDaThuc() {
        for(int i=0; i<dt.size()-1; i++){
            for(int j=i+1; j<dt.size(); j++){
                if(dt.get(i).getSoMu()==dt.get(j).getSoMu()) {
                    hangtu a = new hangtu(dt.get(i).getSoMu(), dt.get(i).getHeSo() + dt.get(j).getHeSo());
                    dt.set(i, a);
                    dt.set(j,new hangtu(0,0));
                }
            }
        }
        for(int i=0; i<dt.size(); i++){
            if(dt.get(i).getSoMu()==0 && dt.get(i).getHeSo()==0) {
                dt.remove(i);
                i--;
            }
        }
    }

    //Cong 2 da thuc:
    dathuc cong2DaThuc(dathuc d2){
        dathuc d3 = new dathuc();
        d3.dt.addAll(dt);
        d3.dt.addAll(d2.dt);
        d3.xuliDaThuc();
        return d3;
    }

    //in:
    void inDaThuc(){
        xuliDaThuc();
        //sap xep:
        for(int i=0; i<dt.size()-1; i++){
            for(int j=i+1; j<dt.size(); j++){
                if(dt.get(i).getSoMu()>dt.get(j).getSoMu()){
                    hangtu a = new hangtu(dt.get(i).getSoMu(),dt.get(i).getHeSo());
                    dt.set(i,dt.get(j));
                    dt.set(j,a);
                }
            }
        }
        //In:
        System.out.print("\n"+dt.get(0).getHeSo()+"*x^"+dt.get(0).getSoMu());
        for(int i=1; i<dt.size(); i++){
            if(dt.get(i).getHeSo()>=0){
                System.out.print(" + "+dt.get(i).getHeSo()+"*x^"+dt.get(i).getSoMu());
            }
            else{
                System.out.print(" - "+(-dt.get(i).getHeSo())+"*x^"+dt.get(i).getSoMu());
            }
        }
    }

    //tinh gia tri:
    double tinhDaThuc(double x){
        double gt = 0;
        for(int i=0; i<dt.size(); i++){
            gt += dt.get(i).getHeSo()* pow(x,dt.get(i).getSoMu());
        }
        return gt;
    }
}