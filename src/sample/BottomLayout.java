package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.json.JSONArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class BottomLayout {
    @FXML
    private TextField txt;
    public void submit(ActionEvent event) throws Exception {
        if(!txt.getText().toString().isEmpty() && isInteger(txt.getText().toString())){
            int num=Integer.parseInt(txt.getText().toString());
            if(num>0) {
                System.out.println(txt.getText().toString());
                fetchList(num);
            }
        }
    }

    private void fetchList(int num) throws IOException {
        JSONArray jsonArray=new JSONArray("[{\"name\":\"Dr. M. Kaykobad\",\"designation\":\"Professor\",\"image\":\"https://cse.buet.ac.bd/faculty/photos/kaykobadkaykobad.jpg\"},{\"name\":\"Dr. Muhammad Masroor Ali\",\"designation\":\"Professor\",\"image\":\"https://cse.buet.ac.bd/faculty/photos/mmasrooralimasroorPPphoto.jpg\"},{\"name\":\"Dr. Md. Abul Kashem Mia\",\"designation\":\"Professor\",\"image\":\"https://cse.buet.ac.bd/faculty/photos/kashemkashem+sir+2.jpg\"},{\"name\":\"Dr. Md. Mostofa Akbar\",\"designation\":\"Professor\",\"image\":\"https://cse.buet.ac.bd/faculty/photos/mostofamostofa.jpg\"},{\"name\":\"Dr. Abu Sayed Md. Latiful Hoque\",\"designation\":\"Professor\",\"image\":\"https://cse.buet.ac.bd/faculty/photos/asmlatifulhoquenoimage.jpg\"},{\"name\":\"Dr. M. Sohel Rahman\",\"designation\":\"Professor\",\"image\":\"https://cse.buet.ac.bd/faculty/photos/msrahmansohel.jpg\"},{\"name\":\"Dr. A.K.M. Ashikur Rahman\",\"designation\":\"Professor\",\"image\":\"https://cse.buet.ac.bd/faculty/photos/ashikurrahmanashikurrahmanpic2.jpg\"},{\"name\":\"Dr. Mohammed Eunus Ali\",\"designation\":\"Professor\",\"image\":\"https://cse.buet.ac.bd/faculty/photos/eunuseunus.jpg\"},{\"name\":\"Dr. Mahmuda Naznin\",\"designation\":\"Professor\",\"image\":\"https://cse.buet.ac.bd/faculty/photos/mahmudanazninFB_IMG_1548053480473.jpg\"},{\"name\":\"Dr. Tanzima Hashem\",\"designation\":\"Professor\",\"image\":\"https://cse.buet.ac.bd/faculty/photos/tanzimahashemIMG_6109.JPG\"},{\"name\":\"Dr. Md. Shohrab Hossain\",\"designation\":\"Professor\",\"image\":\"https://cse.buet.ac.bd/faculty/photos/mshohrabhossainMSH.JPG\"},{\"name\":\"Dr. Anindya Iqbal\",\"designation\":\"Associate Professor\",\"image\":\"https://cse.buet.ac.bd/faculty/photos/anindyaiqbalanindya.jpg\"},{\"name\":\"Dr. Rifat Shahriyar\",\"designation\":\"Associate Professor\",\"image\":\"https://cse.buet.ac.bd/faculty/photos/rifatpic.jpg\"},{\"name\":\"Abu Wasif\",\"designation\":\"Assistant Professor\",\"image\":\"https://cse.buet.ac.bd/faculty/photos/wasifwasif_p.JPG\"},{\"name\":\"Tanveer Awal\",\"designation\":\"Assistant Professor\",\"image\":\"https://cse.buet.ac.bd/faculty/photos/tanveerawalTanveerAwal.jpg\"},{\"name\":\"Khaled Mahmud Shahriar\",\"designation\":\"Assistant Professor\",\"image\":\"https://cse.buet.ac.bd/faculty/photos/khaledshahriarmyfigure.jpg\"},{\"name\":\"Dr. Muhammad Abdullah Adnan\",\"designation\":\"Assistant Professor\",\"image\":\"https://cse.buet.ac.bd/faculty/photos/adnanAdnanweb2.jpg\"},{\"name\":\"Dr. Md. Shamsuzzoha Bayzid\",\"designation\":\"Assistant Professor\",\"image\":\"https://cse.buet.ac.bd/faculty/photos/bayzid1.JPG\"},{\"name\":\"Dr. Mohammad Saifur Rahman\",\"designation\":\"Assistant Professor\",\"image\":\"https://cse.buet.ac.bd/faculty/photos/mrahmanSaifur_Rahman.jpg\"},{\"name\":\"Dr. Atif Hasan Rahman\",\"designation\":\"Assistant Professor\",\"image\":\"https://cse.buet.ac.bd/faculty/photos/atifb721a613-d40f-422e-84f2-06dd275d0bcc.jpg\"},{\"name\":\"Madhusudan Basak\",\"designation\":\"Assistant Professor\",\"image\":\"https://cse.buet.ac.bd/faculty/photos/madhusudan16922.jpg\"},{\"name\":\"Dr. Rezwana Reaz \",\"designation\":\"Lecturer\",\"image\":\"https://cse.buet.ac.bd/faculty/photos/rezwanaprof.jpg\"},{\"name\":\"Mahmudur Rahman Hera\",\"designation\":\"Lecturer\",\"image\":\"https://cse.buet.ac.bd/faculty/photos/mahmudheraimg.jpg\"},{\"name\":\"Md. Saiful Islam\",\"designation\":\"Lecturer\",\"image\":\"https://cse.buet.ac.bd/faculty/photos/saifulislam.jpg\"},{\"name\":\"Mahjabin Nahar\",\"designation\":\"Lecturer\",\"image\":\"https://cse.buet.ac.bd/faculty/photos/mahjabinmahjabin.jpg\"},{\"name\":\"Nafis Irtiza Tripto\",\"designation\":\"Lecturer\",\"image\":\"https://cse.buet.ac.bd/faculty/photos/tripto.jpg\"},{\"name\":\"T. M. Tariq Adnan\",\"designation\":\"Lecturer\",\"image\":\"https://cse.buet.ac.bd/faculty/photos/tariqIMG_0209.jpg\"},{\"name\":\"Shadman Saqib Eusuf\",\"designation\":\"Lecturer\",\"image\":\"https://cse.buet.ac.bd/faculty/photos/ssaqibSaqib.jpg\"},{\"name\":\"Preetom Saha Arko\",\"designation\":\"Lecturer\",\"image\":\"https://cse.buet.ac.bd/faculty/photos/arko50830633_1984343114934662_1484507325048815616_o.jpg\"},{\"name\":\"Sakshar Chakravarty\",\"designation\":\"Lecturer\",\"image\":\"https://cse.buet.ac.bd/faculty/photos/saksharSakshar_high_quality.jpg\"},{\"name\":\"Md. Tareq Mahmood\",\"designation\":\"Lecturer\",\"image\":\"https://cse.buet.ac.bd/faculty/photos/tareqtareq.jpg\"},{\"name\":\"Shehab Sarar Ahmed\",\"designation\":\"Lecturer\",\"image\":\"https://cse.buet.ac.bd/faculty/photos/shehabCapture.JPG\"},{\"name\":\"Md. Masum Mushfiq\",\"designation\":\"Lecturer\",\"image\":\"https://cse.buet.ac.bd/faculty/photos/mushfiqIMG_20180414_160236.jpg\"},{\"name\":\"Syed Md. Mukit Rashid\",\"designation\":\"Lecturer\",\"image\":\"https://cse.buet.ac.bd/faculty/photos/mukit67149020_2128821407417701_6635795863266394112_n.jpg\"},{\"name\":\"Tahmid Hasan\",\"designation\":\"Lecturer\",\"image\":\"https://cse.buet.ac.bd/faculty/photos/tahmidScreenshot_20190726-182527__01__01.jpg\"},{\"name\":\"Md. Toufikuzzaman\",\"designation\":\"Lecturer\",\"image\":\"https://cse.buet.ac.bd/faculty/photos/toufikuzzamanprofile.jpg\"}]\n");
        System.out.println(jsonArray);
        ListLayout listLayout=new ListLayout(jsonArray,MainScreen.mainGroup);
        listLayout.launch();
    }

    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch(NumberFormatException e) {
            return false;
        } catch(NullPointerException e) {
            return false;
        }
        return true;
    }
}
