package com.example.textgenerated;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button choose_filebtn, btn_generate, btn_copy;
    final String LOG_TAG = "myLogs";
    TextView textView;
    EditText editText;
    int y;
    public static final int PICKFILE_RESULT_CODE = 1;
    private Uri fileUri;
    private String filePath;
    ArrayList<String[]> parsedTextValues= new ArrayList<String[]>();

    ArrayList<String> values1= new ArrayList<String>();
    ArrayList<String> name= new ArrayList<String>();
    ArrayList<String> values2= new ArrayList<String>();
    ArrayList<String> values3= new ArrayList<String>();
    ArrayList<String> textLines;
    private File getExternalPath(String filename) {
        return(new File(Environment.getExternalStorageDirectory(), filename));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE  ) != PackageManager.PERMISSION_GRANTED)//
        {
            requestPermissions( new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1001);

        }
        choose_filebtn = (Button) findViewById(R.id.btn_choose_file);
        btn_generate=(Button) findViewById(R.id.btn_generate);
        btn_copy=(Button) findViewById(R.id.btn_copy);
        textView = (TextView) findViewById(R.id.tv_file_path);
        editText = (EditText) findViewById(R.id.edit_message);
        choose_filebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent chooseFile = new Intent(Intent.ACTION_GET_CONTENT);
                chooseFile.setType("*/*");
                chooseFile = Intent.createChooser(chooseFile, "Choose a file");
                startActivityForResult(chooseFile, PICKFILE_RESULT_CODE);
            }
        });
        btn_copy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = getApplicationContext();
                ClipboardManager clipboard = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("", editText.getText().toString());
                clipboard.setPrimaryClip(clip);
            }
        });

        btn_generate.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            editText.setText("Привет,Игорь,");


            ArrayList<Integer> groupIds = new ArrayList<Integer>();
            ArrayList<String>  groupsName=new ArrayList<String>();
        for ( y=0;y<textLines.size();y++){
            String line= textLines.get(y);
            String[] words = line.split("  ");
            for (String word : words) {
                System.out.println(word);}
            parsedTextValues.add(words);

            int num=  Integer.parseInt(words[0]);
            System.out.println(num);
            String name= words[1];
           // System.out.println(name);
            System.out.println(name);
            groupIds.add(num);
            groupsName.add(name);
        }
        //for (int l =1;l<4;l++){
            for (int k =0;k<groupIds.size();k++){
                /*if (groupIds.get(k)==l){
                    values.add(groupsName.get(k));*/

                switch (groupIds.get(k)) {
                    case  (1):
                        values1.add(groupsName.get(k));
                        System.out.println(groupsName.get(k));
                        values1.toString();
                       // Random r = new Random();
                        //int index = r.nextInt(values1.size());
                       // editText.getText().append(values1.get(k)); /*values1.get(values1.get(0))*/;
                        break;
                    case (2):
                        values2.add(groupsName.get(k));
break;
                    case (3):
                        values3.add(groupsName.get(k));
                        break;

                }
            }
            Random r = new Random();
            int index1 = r.nextInt(values1.size()-1);
            int index2 = r.nextInt(values2.size()-1);
            int index3 = r.nextInt(values3.size()-1);
            editText.getText().append(" "+values1.get(index1)+" "+values2.get(index2)+" "+values3.get(index3));
            /*values.toString();
            Random r = new Random();
            int index = r.nextInt(values.size());
            editText.getText().append(values.get(index));*/
       // }

        }


        //todo: add sort
       /* for (int i = 0; i< groupIds.size(); i++)
        { for (int k=0;k<parsedTextValues.size();k++){*/

       // }
            // 1) цикл по textLines, и выбираем оттуда все фразы, которые соответствуют groupIds[i], записываем его в новый массив
            // 2) рандом по этому новому массиву - выбираем фразу
        }

            //int k =text.size();
            );         /*  int index = r.nextInt(text.size());
           editText.getText().append(text.get(index1+1));
            if (  index % 2 != 0 ) {
                String dela = text.get(index);
                int start = editText.getSelectionStart();
                editText.getText().append(dela);
            }else return;*/
        }
    //);
    //}




   /* void readFileSD(String filepath) {
        // проверяем доступность SD
        if (!Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED)) {
            Log.d(LOG_TAG, "SD-карта не доступна: " + Environment.getExternalStorageState());
            return;
        }
        // получаем путь к SD
        File sdPath = Environment.getExternalStorageDirectory();
        // добавляем свой каталог к пути
        sdPath = new File(filepath.getAbsolutePath() + "/" + "y");
        // формируем объект File, который содержит путь к файлу
        File sdFile = new File(filepath);
        try {
            // открываем поток для чтения
            BufferedReader br = new BufferedReader(new FileReader(sdFile));
            String str = "";
            // читаем содержимое
            while ((str = br.readLine()) != null) {
                Log.d(LOG_TAG, str);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }*/


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case PICKFILE_RESULT_CODE:
                if (resultCode == RESULT_OK) {
                    //String FilePath = data.getData().getPath();
                   // textView.setText(FilePath);
                    File sdcard = Environment.getExternalStorageDirectory();
                    File file = new File(sdcard,"y.txt");
                    textView.setText(file.toString());
                    System.out.println(file);
                    /*getExternalPath(new File(FilePath).getName());
                    System.out.println(FilePath);
                    System.out.println(getExternalPath(FilePath));
                    System.out.println(getExternalPath(new File(FilePath).getName()));*/
                    textLines=readFile(file);

                }
                break;
        }
    }
  /* @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 1001:
                if (grantResults[0]==PackageManager.PERMISSION_GRANTED) {
                    fileUri = data.getData();
                    filePath = fileUri.getPath();
                    textView.setText(filePath);
                }

                break;
        }
    }*/
  public  ArrayList<String> readFile(File file) {
      try {
          BufferedReader reader = new BufferedReader(new FileReader(file));
         ArrayList<String> line = new ArrayList<String>();
          String s;
         while (( s=reader.readLine()) != null) {

             line.add(s);
             System.out.println(line);

         }
          return line;
     } catch (FileNotFoundException e) {
         e.printStackTrace();
     } catch (IOException e) {
         e.printStackTrace();
     }
     return  null;
 }

     @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case 1001:{
                if (grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    filePath = fileUri.getPath();
                    textView.setText(filePath);


                    /*File sdcard = Environment.getExternalStorageDirectory();

//Создаём объект файла
                    File file = new File(sdcard,"file.txt");

//Read text from file
                    StringBuilder text = new StringBuilder();

                    try {
                        BufferedReader br = new BufferedReader(new FileReader(file));
                        String line;

                        while ((line = br.readLine()) != null) {
                            text.append(line);
                            text.append('\n');
                        }
                    }
                    catch (IOException e) {
                        //Ошибка
                    }

                    Log.d("Data", text);*/
                }
            }
        }
    }
}

///ПРИВЕТ ГИТХАБ
//ПРИВЕТИК
//хелло