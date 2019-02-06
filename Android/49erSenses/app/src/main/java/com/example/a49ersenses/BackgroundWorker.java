package com.example.a49ersenses;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;


public class BackgroundWorker extends AsyncTask<String, Void, String> {

        Context context;
        AlertDialog alertDialog;
        static ArrayList<String> items;
        static int[] lights_main_values,light_first_values;
        protected static String username = "", password = "";
        BackgroundWorker (Context ctx){
            context = ctx;
        }

        @Override
        protected String doInBackground(String... params) {
            String type = params[0];
            String login_url = "http://192.168.1.100/login.php";
            String powerlogin_url = "http://192.168.1.100/powerlogin.php";
            String utilitylogin_url = "http://192.168.1.100/utilitylogin.php";
            String register_url = "http://192.168.1.100/register.php";
            String powerregister_url = "http://192.168.1.100/powerregister.php";
            String utilityregister_url = "http://192.168.1.100/utilityregister.php";
            String disarm_url = "http://192.168.1.100/disarm.php";
            String lightsmain_url = "http://192.168.1.100/lightsmain.php";
            String lightsfirst_url = "http://192.168.1.100/lightsfirst.php";
            String armaway_url = "http://192.168.1.100/armaway.php";
            String armstay_url = "http://192.168.1.100/armstay.php";
            String garageopen_url = "http://192.168.1.100/garageopen.php";
            String garageclose_url = "http://192.168.1.100/garageclose.php";
            String backlock_url = "http://192.168.1.100/backlock.php";
            String backunlock_url = "http://192.168.1.100/backunlock.php";
            String frontlock_url = "http://192.168.1.100/frontlock.php";
            String frontunlock_url = "http://192.168.1.100/frontunlock.php";
            String mainon_url = "http://192.168.1.100/mainon.php";
            String mainoff_url = "http://192.168.1.100/mainoff.php";
            String firston_url = "http://192.168.1.100/firston.php";
            String firstoff_url = "http://192.168.1.100/firstoff.php";
            String heatmain_url = "http://192.168.1.100/heatmain.php";
            String coolmain_url = "http://192.168.1.100/coolmain.php";
            String offmain_url = "http://192.168.1.100/offmain.php";
            String fanonmain_url = "http://192.168.1.100/fanonmain.php";
            String fanautomain_url = "http://192.168.1.100/fanautomain.php";
            String fanoffmain_url = "http://192.168.1.100/fanoffmain.php";
            String heatfirst_url = "http://192.168.1.100/heatfirst.php";
            String coolfirst_url = "http://192.168.1.100/coolfirst.php";
            String offfirst_url = "http://192.168.1.100/offfirst.php";
            String fanonfirst_url = "http://192.168.1.100/fanonfirst.php";
            String fanautofirst_url = "http://192.168.1.100/fanautofirst.php";
            String fanofffirst_url = "http://192.168.1.100/fanofffirst.php";
            String getlights_mainurl = "http://192.168.1.100/getlights_main.php";
            String getlights_firsturl = "http://192.168.1.100/getlights_first.php";

            String joinurl = "http://192.168.1.100/join.php";


            if (type.equals("Login")) {
                try {
                    String user_name = params[1];
                    String password = params[2];
                    username = user_name;
                    URL url = new URL(login_url);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                    String post_data = URLEncoder.encode("user_name", "UTF-8") + "=" + URLEncoder.encode(user_name, "UTF-8") + "&"
                            + URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(password, "UTF-8");
                    bufferedWriter.write(post_data);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    outputStream.close();
                    InputStream inputStream = httpURLConnection.getInputStream();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                    String result = "";
                    String line = "";
                    while ((line = bufferedReader.readLine()) != null) {
                        result += line;

                    }

                    bufferedReader.close();
                    inputStream.close();
                    httpURLConnection.disconnect();


                    return result;
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            if (type.equals("join")) {
                try {
                    URL url1 = new URL(joinurl);
                    HttpURLConnection httpURLConnection1 = (HttpURLConnection) url1.openConnection();
                    httpURLConnection1.setRequestMethod("POST");
                    httpURLConnection1.setDoOutput(true);
                    httpURLConnection1.setDoInput(true);
                    OutputStream outputStream1 = httpURLConnection1.getOutputStream();
                    BufferedWriter bufferedWriter1 = new BufferedWriter(new OutputStreamWriter(outputStream1, "UTF-8"));
                    String post_data1 = URLEncoder.encode("user_name", "UTF-8") + "=" + URLEncoder.encode(username, "UTF-8");
                    bufferedWriter1.write(post_data1);
                    bufferedWriter1.flush();
                    bufferedWriter1.close();
                    outputStream1.close();
                    InputStream inputStream1 = httpURLConnection1.getInputStream();
                    BufferedReader bufferedReader1 = new BufferedReader(new InputStreamReader(inputStream1, "iso-8859-1"));
                    String result1 = "";
                    String line1 = "";
                    while ((line1 = bufferedReader1.readLine()) != null) {
                        result1 += line1;

                    }
                    System.out.println(result1 + "ye aaya result main");


                    String keys[] = new String[]{"main_on","main_off","first_on","fan_off","fan_auto","fan_on","heat","cool","off",
                            "open_door","close_door","master_bedroom","guest_bedroom","living_room","kitchen","porch","back_lock",
                            "back_unlock","front_lock","front_unlock","disarm","arm_stay","arm_away"};
                    String a = result1.replace("main_on=", "");
                    String b = a.replace("main_off=", "");
                    String c = b.replace("first_on=", "");
                    String d = c.replace("fan_off=", "");
                    String e = d.replace("fan_auto=", "");
                    String f = e.replace("fan_on=", "");
                    String g = f.replace("first_on=", "");
                    String h = g.replace("heat=", "");
                    String i = h.replace("cool=", "");
                    String j = i.replace("off=", "");
                    String k = j.replace("open_door=", "");
                    String l = k.replace("close_door=", "");
                    String m = l.replace("master_bedroom=", "");
                    String n = m.replace("guest_bedroom=", "");
                    String o = n.replace("living_room=", "");
                    String p = o.replace("kitchen=", "");
                    String q = p.replace("porch=", "");
                    String r = q.replace("back_lock=", "");
                    String s = r.replace("back_unlock=", "");
                    String t = s.replace("front_lock=", "");
                    String u = t.replace("front_unlock=", "");
                    String v = u.replace("disarm=", "");
                    String w1 = v.replace("arm_stay=", "");

                    String w = w1.replace("arm_away=", "");

                    lights_main_values = new int[]{Integer.parseInt(String.valueOf(w.charAt(0))),
                            Integer.parseInt(String.valueOf(w.charAt(1))),
                            Integer.parseInt(String.valueOf(w.charAt(2))),
                            Integer.parseInt(String.valueOf(w.charAt(3))),
                            Integer.parseInt(String.valueOf(w.charAt(4))),
                            Integer.parseInt(String.valueOf(w.charAt(5))),
                            Integer.parseInt(String.valueOf(w.charAt(6))),
                            Integer.parseInt(String.valueOf(w.charAt(7))),
                            Integer.parseInt(String.valueOf(w.charAt(8))),
                            Integer.parseInt(String.valueOf(w.charAt(9))),
                            Integer.parseInt(String.valueOf(w.charAt(10))),
                            Integer.parseInt(String.valueOf(w.charAt(11))),
                            Integer.parseInt(String.valueOf(w.charAt(12))),
                            Integer.parseInt(String.valueOf(w.charAt(13))),
                            Integer.parseInt(String.valueOf(w.charAt(14))),
                            Integer.parseInt(String.valueOf(w.charAt(15))),

                            Integer.parseInt(String.valueOf(w.charAt(16))),

                            Integer.parseInt(String.valueOf(w.charAt(17))),

                            Integer.parseInt(String.valueOf(w.charAt(18))),

                            Integer.parseInt(String.valueOf(w.charAt(19))),
                            Integer.parseInt(String.valueOf(w.charAt(20))),

                            Integer.parseInt(String.valueOf(w.charAt(21))),
                            Integer.parseInt(String.valueOf(w.charAt(22))),
                    };

                    items = new ArrayList<>();

                    items.add(keys[0] + " = " + lights_main_values[0]);
                    items.add(keys[1] + " = "  + lights_main_values[1]);
                    items.add(keys[2] + " = "  + lights_main_values[2]);
                    items.add(keys[3] + " = "  + lights_main_values[3]);
                    items.add(keys[4] + " = "  + lights_main_values[4]);
                    items.add(keys[5] + " = "  + lights_main_values[5]);
                    items.add(keys[6] + " = "  + lights_main_values[6]);
                    items.add(keys[7] + " = "  + lights_main_values[7]);
                    items.add(keys[8] + " = "  + lights_main_values[8]);
                    items.add(keys[9] + " = "  + lights_main_values[9]);
                    items.add(keys[10] + " = "  + lights_main_values[10]);
                    items.add(keys[11] + " = "  + lights_main_values[11]);
                    items.add(keys[12] + " = "  + lights_main_values[12]);
                    items.add(keys[13] + " = "  + lights_main_values[13]);
                    items.add(keys[14] + " = "  + lights_main_values[14]);
                    items.add(keys[15] + " = "  + lights_main_values[15]);
                    items.add(keys[16] + " = "  + lights_main_values[16]);
                    items.add(keys[17] + " = "  + lights_main_values[17]);
                    items.add(keys[18] + " = "  + lights_main_values[18]);
                    items.add(keys[19] + " = "  + lights_main_values[19]);
                    items.add(keys[20] + " = "  + lights_main_values[20]);
                    items.add(keys[21] + " = "  + lights_main_values[21]);
                    items.add(keys[22] + " = "  + lights_main_values[22]);




                    //System.out.println("print values" + values[0] + " " + values[1] + " " + values[2]);

                        /*
                        String separate[] = result1.split("\n");
                        for(int i =0;i<separate.length;i++){
                            values[i] = separate[i].split("=")[1];
                        }


                    */
                    return "afterjoin";
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (type.equals("getlightsmain")) {
                try {
                    URL url1 = new URL(getlights_mainurl);
                    HttpURLConnection httpURLConnection1 = (HttpURLConnection) url1.openConnection();
                    httpURLConnection1.setRequestMethod("POST");
                    httpURLConnection1.setDoOutput(true);
                    httpURLConnection1.setDoInput(true);
                    OutputStream outputStream1 = httpURLConnection1.getOutputStream();
                    BufferedWriter bufferedWriter1 = new BufferedWriter(new OutputStreamWriter(outputStream1, "UTF-8"));
                    String post_data1 = URLEncoder.encode("user_name", "UTF-8") + "=" + URLEncoder.encode(username, "UTF-8");
                    bufferedWriter1.write(post_data1);
                    bufferedWriter1.flush();
                    bufferedWriter1.close();
                    outputStream1.close();
                    InputStream inputStream1 = httpURLConnection1.getInputStream();
                    BufferedReader bufferedReader1 = new BufferedReader(new InputStreamReader(inputStream1, "iso-8859-1"));
                    String result1 = "";
                    String line1 = "";
                    while ((line1 = bufferedReader1.readLine()) != null) {
                        result1 += line1;

                    }
                    String a = result1.replace("living_room=", "");
                    String b = a.replace("kitchen=", "");
                    String c = b.replace("porch=", "");

                    lights_main_values = new int[]{Integer.parseInt(String.valueOf(c.charAt(0))), Integer.parseInt(String.valueOf(c.charAt(1))), Integer.parseInt(String.valueOf(c.charAt(2)))};

                    //System.out.println("print values" + values[0] + " " + values[1] + " " + values[2]);

                        /*
                        String separate[] = result1.split("\n");
                        for(int i =0;i<separate.length;i++){
                            values[i] = separate[i].split("=")[1];
                        }


                    */
                    return "lights_main";
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

                if(type.equals("getlightsfirst")){
                    try {
                        URL url1 = new URL(getlights_firsturl);
                        HttpURLConnection httpURLConnection1 = (HttpURLConnection) url1.openConnection();
                        httpURLConnection1.setRequestMethod("POST");
                        httpURLConnection1.setDoOutput(true);
                        httpURLConnection1.setDoInput(true);
                        OutputStream outputStream1 = httpURLConnection1.getOutputStream();
                        BufferedWriter bufferedWriter1 = new BufferedWriter(new OutputStreamWriter(outputStream1, "UTF-8"));
                        String post_data1 = URLEncoder.encode("user_name", "UTF-8") + "=" + URLEncoder.encode(username, "UTF-8");
                        bufferedWriter1.write(post_data1);
                        bufferedWriter1.flush();
                        bufferedWriter1.close();
                        outputStream1.close();
                        InputStream inputStream1 = httpURLConnection1.getInputStream();
                        BufferedReader bufferedReader1 = new BufferedReader(new InputStreamReader(inputStream1, "iso-8859-1"));
                        String result1 = "";
                        String line1 = "";
                        while ((line1 = bufferedReader1.readLine()) != null) {
                            result1 += line1;

                        }
                        System.out.println(result1);
                        String a = result1.replace("master_bedroom=", "");
                        String b = a.replace("guest_bedroom=", "");

                        light_first_values = new int[]{Integer.parseInt(String.valueOf(b.charAt(0))), Integer.parseInt(String.valueOf(b.charAt(1)))};

                        //System.out.println("print values" + values[0] + " " + values[1] + " " + values[2]);

                        /*
                        String separate[] = result1.split("\n");
                        for(int i =0;i<separate.length;i++){
                            values[i] = separate[i].split("=")[1];
                        }


                    */
                        return "lights_first";
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }



                if (type.equals("Power Login")) {
                    try {
                        String user_name = params[1];
                        String password = params[2];
                        username = user_name;
                        URL url = new URL(powerlogin_url);
                        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                        httpURLConnection.setRequestMethod("POST");
                        httpURLConnection.setDoOutput(true);
                        httpURLConnection.setDoInput(true);
                        OutputStream outputStream = httpURLConnection.getOutputStream();
                        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                        String post_data = URLEncoder.encode("user_name", "UTF-8") + "=" + URLEncoder.encode(user_name, "UTF-8") + "&"
                                + URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(password, "UTF-8");
                        bufferedWriter.write(post_data);
                        bufferedWriter.flush();
                        bufferedWriter.close();
                        outputStream.close();
                        InputStream inputStream = httpURLConnection.getInputStream();
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                        String result = "";
                        String line = "";
                        while ((line = bufferedReader.readLine()) != null) {
                            result += line;

                        }

                        bufferedReader.close();
                        inputStream.close();
                        httpURLConnection.disconnect();
                        return result;
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }

                if (type.equals("Utility Login")) {
                    try {
                        String user_name = params[1];
                        String password = params[2];
                        username = user_name;
                        URL url = new URL(utilitylogin_url);
                        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                        httpURLConnection.setRequestMethod("POST");
                        httpURLConnection.setDoOutput(true);
                        httpURLConnection.setDoInput(true);
                        OutputStream outputStream = httpURLConnection.getOutputStream();
                        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                        String post_data = URLEncoder.encode("user_name", "UTF-8") + "=" + URLEncoder.encode(user_name, "UTF-8") + "&"
                                + URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(password, "UTF-8");
                        bufferedWriter.write(post_data);
                        bufferedWriter.flush();
                        bufferedWriter.close();
                        outputStream.close();
                        InputStream inputStream = httpURLConnection.getInputStream();
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                        String result = "";
                        String line = "";
                        while ((line = bufferedReader.readLine()) != null) {
                            result += line;

                        }

                        bufferedReader.close();
                        inputStream.close();
                        httpURLConnection.disconnect();
                        return result;
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                } else if (type.equals("Register")) {
                    try {
                        String name = params[1];
                        String surname = params[2];
                        String user_name = params[3];
                        String password = params[4];
                        String mobile_num = params[5];
                        String email_id = params[6];
                        String user = params[7];
                        URL url = new URL(register_url);
                        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                        httpURLConnection.setRequestMethod("POST");
                        httpURLConnection.setDoOutput(true);
                        httpURLConnection.setDoInput(true);
                        OutputStream outputStream = httpURLConnection.getOutputStream();
                        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                        String post_data = URLEncoder.encode("name", "UTF-8") + "=" + URLEncoder.encode(name, "UTF-8") + "&"
                                + URLEncoder.encode("surname", "UTF-8") + "=" + URLEncoder.encode(surname, "UTF-8") + "&"
                                + URLEncoder.encode("user_name", "UTF-8") + "=" + URLEncoder.encode(user_name, "UTF-8") + "&"
                                + URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(password, "UTF-8") + "&"
                                + URLEncoder.encode("mobile_num", "UTF-8") + "=" + URLEncoder.encode(mobile_num, "UTF-8") + "&"
                                + URLEncoder.encode("email_id", "UTF-8") + "=" + URLEncoder.encode(email_id, "UTF-8") + "&"
                                + URLEncoder.encode("user", "UTF-8") + "=" + URLEncoder.encode(user, "UTF-8");
                        bufferedWriter.write(post_data);
                        bufferedWriter.flush();
                        bufferedWriter.close();
                        outputStream.close();

                        InputStream inputStream = httpURLConnection.getInputStream();
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                        String result = "";
                        String line = "";
                        while ((line = bufferedReader.readLine()) != null) {
                            result += line;
                        }
                        bufferedReader.close();
                        inputStream.close();
                        httpURLConnection.disconnect();
                        return result;
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                } else if (type.equals("Power Register")) {
                    try {
                        String name = params[1];
                        String user_name = params[2];
                        String password = params[3];
                        String mobile_num = params[4];
                        String email_id = params[5];
                        String user = params[6];
                        URL url = new URL(powerregister_url);
                        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                        httpURLConnection.setRequestMethod("POST");
                        httpURLConnection.setDoOutput(true);
                        httpURLConnection.setDoInput(true);
                        OutputStream outputStream = httpURLConnection.getOutputStream();
                        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                        String post_data = URLEncoder.encode("name", "UTF-8") + "=" + URLEncoder.encode(name, "UTF-8") + "&"
                                + URLEncoder.encode("user_name", "UTF-8") + "=" + URLEncoder.encode(user_name, "UTF-8") + "&"
                                + URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(password, "UTF-8") + "&"
                                + URLEncoder.encode("mobile_num", "UTF-8") + "=" + URLEncoder.encode(mobile_num, "UTF-8") + "&"
                                + URLEncoder.encode("email_id", "UTF-8") + "=" + URLEncoder.encode(email_id, "UTF-8") + "&"
                                + URLEncoder.encode("user", "UTF-8") + "=" + URLEncoder.encode(user, "UTF-8");
                        bufferedWriter.write(post_data);
                        bufferedWriter.flush();
                        bufferedWriter.close();
                        outputStream.close();

                        InputStream inputStream = httpURLConnection.getInputStream();
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                        String result = "";
                        String line = "";
                        while ((line = bufferedReader.readLine()) != null) {
                            result += line;
                        }
                        bufferedReader.close();
                        inputStream.close();
                        httpURLConnection.disconnect();
                        return result;
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                } else if (type.equals("Utility Register")) {
                    try {
                        String name = params[1];
                        String user_name = params[2];
                        String password = params[3];
                        String mobile_num = params[4];
                        String email_id = params[5];
                        String user = params[6];
                        URL url = new URL(utilityregister_url);
                        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                        httpURLConnection.setRequestMethod("POST");
                        httpURLConnection.setDoOutput(true);
                        httpURLConnection.setDoInput(true);
                        OutputStream outputStream = httpURLConnection.getOutputStream();
                        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                        String post_data = URLEncoder.encode("name", "UTF-8") + "=" + URLEncoder.encode(name, "UTF-8") + "&"
                                + URLEncoder.encode("user_name", "UTF-8") + "=" + URLEncoder.encode(user_name, "UTF-8") + "&"
                                + URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(password, "UTF-8") + "&"
                                + URLEncoder.encode("mobile_num", "UTF-8") + "=" + URLEncoder.encode(mobile_num, "UTF-8") + "&"
                                + URLEncoder.encode("email_id", "UTF-8") + "=" + URLEncoder.encode(email_id, "UTF-8") + "&"
                                + URLEncoder.encode("user", "UTF-8") + "=" + URLEncoder.encode(user, "UTF-8");
                        bufferedWriter.write(post_data);
                        bufferedWriter.flush();
                        bufferedWriter.close();
                        outputStream.close();

                        InputStream inputStream = httpURLConnection.getInputStream();
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                        String result = "";
                        String line = "";
                        while ((line = bufferedReader.readLine()) != null) {
                            result += line;
                        }
                        bufferedReader.close();
                        inputStream.close();
                        httpURLConnection.disconnect();
                        return result;
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                } else if (type.equals("lightsmain")) {
                    try {
                        String kitchen = params[1];
                        String porch = params[2];
                        String lroom = params[3];
                        URL url = new URL(lightsmain_url);
                        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                        httpURLConnection.setRequestMethod("POST");
                        httpURLConnection.setDoOutput(true);
                        httpURLConnection.setDoInput(true);
                        OutputStream outputStream = httpURLConnection.getOutputStream();
                        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                        String post_data = URLEncoder.encode("kitchen", "UTF-8") + "=" + URLEncoder.encode(kitchen, "UTF-8") + "&"
                                + URLEncoder.encode("porch", "UTF-8") + "=" + URLEncoder.encode(porch, "UTF-8") + "&"
                                + URLEncoder.encode("lroom", "UTF-8") + "=" + URLEncoder.encode(lroom, "UTF-8") + "&"
                                + URLEncoder.encode("user_name", "UTF-8") + "=" + URLEncoder.encode(BackgroundWorker.username, "UTF-8");
                        bufferedWriter.write(post_data);

                        bufferedWriter.flush();
                        bufferedWriter.close();
                        outputStream.close();
                        InputStream inputStream = httpURLConnection.getInputStream();
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                        String result = "";
                        String line = "";
                        while ((line = bufferedReader.readLine()) != null) {
                            result += line;
                        }
                        bufferedReader.close();
                        inputStream.close();
                        httpURLConnection.disconnect();
                        return result;
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                } else if (type.equals("lightsfirst")) {
                    try {
                        String masterbed = params[1];
                        String guestbed = params[2];
                        URL url = new URL(lightsfirst_url);
                        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                        httpURLConnection.setRequestMethod("POST");
                        httpURLConnection.setDoOutput(true);
                        httpURLConnection.setDoInput(true);
                        OutputStream outputStream = httpURLConnection.getOutputStream();
                        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                        String post_data = URLEncoder.encode("master_bedroom", "UTF-8") + "=" + URLEncoder.encode(masterbed, "UTF-8") + "&"
                                + URLEncoder.encode("guest_bedroom", "UTF-8") + "=" + URLEncoder.encode(guestbed, "UTF-8") + "&"
                                + URLEncoder.encode("user_name", "UTF-8") + "=" + URLEncoder.encode(BackgroundWorker.username, "UTF-8");
                        bufferedWriter.write(post_data);
                        bufferedWriter.flush();
                        bufferedWriter.close();
                        outputStream.close();
                        InputStream inputStream = httpURLConnection.getInputStream();
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                        String result = "";
                        String line = "";
                        while ((line = bufferedReader.readLine()) != null) {
                            result += line;
                        }
                        bufferedReader.close();
                        inputStream.close();
                        httpURLConnection.disconnect();
                        return result;
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                } else if (type.equals("Disarm")) {
                    try {
                        String disarm = params[1];
                        String armaway = params[2];
                        String armstay = params[3];
                        URL url = new URL(disarm_url);
                        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                        httpURLConnection.setRequestMethod("POST");
                        httpURLConnection.setDoOutput(true);
                        httpURLConnection.setDoInput(true);
                        OutputStream outputStream = httpURLConnection.getOutputStream();
                        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                        String post_data = URLEncoder.encode("disarm", "UTF-8") + "=" + URLEncoder.encode(disarm, "UTF-8") + "&"
                                + URLEncoder.encode("arm_away", "UTF-8") + "=" + URLEncoder.encode(armaway, "UTF-8") + "&"
                                + URLEncoder.encode("arm_stay", "UTF-8") + "=" + URLEncoder.encode(armstay, "UTF-8") + "&"
                                + URLEncoder.encode("user_name", "UTF-8") + "=" + URLEncoder.encode(BackgroundWorker.username, "UTF-8");
                        bufferedWriter.write(post_data);

                        bufferedWriter.flush();
                        bufferedWriter.close();
                        outputStream.close();
                        InputStream inputStream = httpURLConnection.getInputStream();
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                        String result = "";
                        String line = "";
                        while ((line = bufferedReader.readLine()) != null) {
                            result += line;
                        }
                        bufferedReader.close();
                        inputStream.close();
                        httpURLConnection.disconnect();
                        return result;
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                } else if (type.equals("Armaway")) {
                    try {
                        String disarm = params[1];
                        String armaway = params[2];
                        String armstay = params[3];
                        URL url = new URL(armaway_url);
                        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                        httpURLConnection.setRequestMethod("POST");
                        httpURLConnection.setDoOutput(true);
                        httpURLConnection.setDoInput(true);
                        OutputStream outputStream = httpURLConnection.getOutputStream();
                        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                        String post_data = URLEncoder.encode("disarm", "UTF-8") + "=" + URLEncoder.encode(disarm, "UTF-8") + "&"
                                + URLEncoder.encode("arm_away", "UTF-8") + "=" + URLEncoder.encode(armaway, "UTF-8") + "&"
                                + URLEncoder.encode("arm_stay", "UTF-8") + "=" + URLEncoder.encode(armstay, "UTF-8") + "&"
                                + URLEncoder.encode("user_name", "UTF-8") + "=" + URLEncoder.encode(BackgroundWorker.username, "UTF-8");
                        bufferedWriter.write(post_data);

                        bufferedWriter.flush();
                        bufferedWriter.close();
                        outputStream.close();
                        InputStream inputStream = httpURLConnection.getInputStream();
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                        String result = "";
                        String line = "";
                        while ((line = bufferedReader.readLine()) != null) {
                            result += line;
                        }
                        bufferedReader.close();
                        inputStream.close();
                        httpURLConnection.disconnect();
                        return result;
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                } else if (type.equals("Armstay")) {
                    try {
                        String disarm = params[1];
                        String armaway = params[2];
                        String armstay = params[3];
                        URL url = new URL(armstay_url);
                        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                        httpURLConnection.setRequestMethod("POST");
                        httpURLConnection.setDoOutput(true);
                        httpURLConnection.setDoInput(true);
                        OutputStream outputStream = httpURLConnection.getOutputStream();
                        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                        String post_data = URLEncoder.encode("disarm", "UTF-8") + "=" + URLEncoder.encode(disarm, "UTF-8") + "&"
                                + URLEncoder.encode("arm_away", "UTF-8") + "=" + URLEncoder.encode(armaway, "UTF-8") + "&"
                                + URLEncoder.encode("arm_stay", "UTF-8") + "=" + URLEncoder.encode(armstay, "UTF-8") + "&"
                                + URLEncoder.encode("user_name", "UTF-8") + "=" + URLEncoder.encode(BackgroundWorker.username, "UTF-8");
                        bufferedWriter.write(post_data);

                        bufferedWriter.flush();
                        bufferedWriter.close();
                        outputStream.close();
                        InputStream inputStream = httpURLConnection.getInputStream();
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                        String result = "";
                        String line = "";
                        while ((line = bufferedReader.readLine()) != null) {
                            result += line;
                        }
                        bufferedReader.close();
                        inputStream.close();
                        httpURLConnection.disconnect();
                        return result;
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                } else if (type.equals("Garageopen")) {
                    try {
                        String opendoor = params[1];
                        String closedoor = params[2];
                        URL url = new URL(garageopen_url);
                        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                        httpURLConnection.setRequestMethod("POST");
                        httpURLConnection.setDoOutput(true);
                        httpURLConnection.setDoInput(true);
                        OutputStream outputStream = httpURLConnection.getOutputStream();
                        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                        String post_data = URLEncoder.encode("open_door", "UTF-8") + "=" + URLEncoder.encode(opendoor, "UTF-8") + "&"
                                + URLEncoder.encode("close_door", "UTF-8") + "=" + URLEncoder.encode(closedoor, "UTF-8") + "&"
                                + URLEncoder.encode("user_name", "UTF-8") + "=" + URLEncoder.encode(BackgroundWorker.username, "UTF-8");
                        bufferedWriter.write(post_data);

                        bufferedWriter.flush();
                        bufferedWriter.close();
                        outputStream.close();
                        InputStream inputStream = httpURLConnection.getInputStream();
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                        String result = "";
                        String line = "";
                        while ((line = bufferedReader.readLine()) != null) {
                            result += line;
                        }
                        bufferedReader.close();
                        inputStream.close();
                        httpURLConnection.disconnect();
                        return result;
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                } else if (type.equals("Garageclose")) {
                    try {
                        String opendoor = params[1];
                        String closedoor = params[2];
                        URL url = new URL(garageclose_url);
                        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                        httpURLConnection.setRequestMethod("POST");
                        httpURLConnection.setDoOutput(true);
                        httpURLConnection.setDoInput(true);
                        OutputStream outputStream = httpURLConnection.getOutputStream();
                        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                        String post_data = URLEncoder.encode("open_door", "UTF-8") + "=" + URLEncoder.encode(opendoor, "UTF-8") + "&"
                                + URLEncoder.encode("close_door", "UTF-8") + "=" + URLEncoder.encode(closedoor, "UTF-8") + "&"
                                + URLEncoder.encode("user_name", "UTF-8") + "=" + URLEncoder.encode(BackgroundWorker.username, "UTF-8");
                        bufferedWriter.write(post_data);

                        bufferedWriter.flush();
                        bufferedWriter.close();
                        outputStream.close();
                        InputStream inputStream = httpURLConnection.getInputStream();
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                        String result = "";
                        String line = "";
                        while ((line = bufferedReader.readLine()) != null) {
                            result += line;
                        }
                        bufferedReader.close();
                        inputStream.close();
                        httpURLConnection.disconnect();
                        return result;
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                } else if (type.equals("Backlock")) {
                    try {
                        String backlock = params[1];
                        String backunlock = params[2];
                        URL url = new URL(backlock_url);
                        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                        httpURLConnection.setRequestMethod("POST");
                        httpURLConnection.setDoOutput(true);
                        httpURLConnection.setDoInput(true);
                        OutputStream outputStream = httpURLConnection.getOutputStream();
                        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                        String post_data = URLEncoder.encode("back_lock", "UTF-8") + "=" + URLEncoder.encode(backlock, "UTF-8") + "&"
                                + URLEncoder.encode("back_unlock", "UTF-8") + "=" + URLEncoder.encode(backunlock, "UTF-8") + "&"
                                + URLEncoder.encode("user_name", "UTF-8") + "=" + URLEncoder.encode(BackgroundWorker.username, "UTF-8");
                        bufferedWriter.write(post_data);

                        bufferedWriter.flush();
                        bufferedWriter.close();
                        outputStream.close();
                        InputStream inputStream = httpURLConnection.getInputStream();
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                        String result = "";
                        String line = "";
                        while ((line = bufferedReader.readLine()) != null) {
                            result += line;
                        }
                        bufferedReader.close();
                        inputStream.close();
                        httpURLConnection.disconnect();
                        return result;
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                } else if (type.equals("Backunlock")) {
                    try {
                        String backlock = params[1];
                        String backunlock = params[2];
                        URL url = new URL(backunlock_url);
                        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                        httpURLConnection.setRequestMethod("POST");
                        httpURLConnection.setDoOutput(true);
                        httpURLConnection.setDoInput(true);
                        OutputStream outputStream = httpURLConnection.getOutputStream();
                        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                        String post_data = URLEncoder.encode("back_lock", "UTF-8") + "=" + URLEncoder.encode(backlock, "UTF-8") + "&"
                                + URLEncoder.encode("back_unlock", "UTF-8") + "=" + URLEncoder.encode(backunlock, "UTF-8") + "&"
                                + URLEncoder.encode("user_name", "UTF-8") + "=" + URLEncoder.encode(BackgroundWorker.username, "UTF-8");
                        bufferedWriter.write(post_data);

                        bufferedWriter.flush();
                        bufferedWriter.close();
                        outputStream.close();
                        InputStream inputStream = httpURLConnection.getInputStream();
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                        String result = "";
                        String line = "";
                        while ((line = bufferedReader.readLine()) != null) {
                            result += line;
                        }
                        bufferedReader.close();
                        inputStream.close();
                        httpURLConnection.disconnect();
                        return result;
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                } else if (type.equals("Frontlock")) {
                    try {
                        String frontlock = params[1];
                        String frontunlock = params[2];
                        URL url = new URL(frontlock_url);
                        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                        httpURLConnection.setRequestMethod("POST");
                        httpURLConnection.setDoOutput(true);
                        httpURLConnection.setDoInput(true);
                        OutputStream outputStream = httpURLConnection.getOutputStream();
                        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                        String post_data = URLEncoder.encode("front_lock", "UTF-8") + "=" + URLEncoder.encode(frontlock, "UTF-8") + "&"
                                + URLEncoder.encode("front_unlock", "UTF-8") + "=" + URLEncoder.encode(frontunlock, "UTF-8") + "&"
                                + URLEncoder.encode("user_name", "UTF-8") + "=" + URLEncoder.encode(BackgroundWorker.username, "UTF-8");
                        bufferedWriter.write(post_data);

                        bufferedWriter.flush();
                        bufferedWriter.close();
                        outputStream.close();
                        InputStream inputStream = httpURLConnection.getInputStream();
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                        String result = "";
                        String line = "";
                        while ((line = bufferedReader.readLine()) != null) {
                            result += line;
                        }
                        bufferedReader.close();
                        inputStream.close();
                        httpURLConnection.disconnect();
                        return result;
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                } else if (type.equals("Frontunlock")) {
                    try {
                        String frontlock = params[1];
                        String frontunlock = params[2];
                        URL url = new URL(frontunlock_url);
                        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                        httpURLConnection.setRequestMethod("POST");
                        httpURLConnection.setDoOutput(true);
                        httpURLConnection.setDoInput(true);
                        OutputStream outputStream = httpURLConnection.getOutputStream();
                        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                        String post_data = URLEncoder.encode("front_lock", "UTF-8") + "=" + URLEncoder.encode(frontlock, "UTF-8") + "&"
                                + URLEncoder.encode("front_unlock", "UTF-8") + "=" + URLEncoder.encode(frontunlock, "UTF-8") + "&"
                                + URLEncoder.encode("user_name", "UTF-8") + "=" + URLEncoder.encode(BackgroundWorker.username, "UTF-8");
                        bufferedWriter.write(post_data);

                        bufferedWriter.flush();
                        bufferedWriter.close();
                        outputStream.close();
                        InputStream inputStream = httpURLConnection.getInputStream();
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                        String result = "";
                        String line = "";
                        while ((line = bufferedReader.readLine()) != null) {
                            result += line;
                        }
                        bufferedReader.close();
                        inputStream.close();
                        httpURLConnection.disconnect();
                        return result;
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                } else if (type.equals("Mainon")) {
                    try {
                        String mainon = params[1];
                        String mainoff = params[2];
                        URL url = new URL(mainon_url);
                        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                        httpURLConnection.setRequestMethod("POST");
                        httpURLConnection.setDoOutput(true);
                        httpURLConnection.setDoInput(true);
                        OutputStream outputStream = httpURLConnection.getOutputStream();
                        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                        String post_data = URLEncoder.encode("main_on", "UTF-8") + "=" + URLEncoder.encode(mainon, "UTF-8") + "&"
                                + URLEncoder.encode("main_off", "UTF-8") + "=" + URLEncoder.encode(mainoff, "UTF-8") + "&"
                                + URLEncoder.encode("user_name", "UTF-8") + "=" + URLEncoder.encode(BackgroundWorker.username, "UTF-8");
                        bufferedWriter.write(post_data);
                        bufferedWriter.flush();
                        bufferedWriter.close();
                        outputStream.close();
                        InputStream inputStream = httpURLConnection.getInputStream();
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                        String result = "";
                        String line = "";
                        while ((line = bufferedReader.readLine()) != null) {
                            result += line;
                        }
                        bufferedReader.close();
                        inputStream.close();
                        httpURLConnection.disconnect();
                        return result;
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                } else if (type.equals("Mainoff")) {
                    try {
                        String mainon = params[1];
                        String mainoff = params[2];
                        URL url = new URL(mainoff_url);
                        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                        httpURLConnection.setRequestMethod("POST");
                        httpURLConnection.setDoOutput(true);
                        httpURLConnection.setDoInput(true);
                        OutputStream outputStream = httpURLConnection.getOutputStream();
                        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                        String post_data = URLEncoder.encode("main_on", "UTF-8") + "=" + URLEncoder.encode(mainon, "UTF-8") + "&"
                                + URLEncoder.encode("main_off", "UTF-8") + "=" + URLEncoder.encode(mainoff, "UTF-8") + "&"
                                + URLEncoder.encode("user_name", "UTF-8") + "=" + URLEncoder.encode(BackgroundWorker.username, "UTF-8");
                        bufferedWriter.write(post_data);

                        bufferedWriter.flush();
                        bufferedWriter.close();
                        outputStream.close();
                        InputStream inputStream = httpURLConnection.getInputStream();
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                        String result = "";
                        String line = "";
                        while ((line = bufferedReader.readLine()) != null) {
                            result += line;
                        }
                        bufferedReader.close();
                        inputStream.close();
                        httpURLConnection.disconnect();
                        return result;
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                } else if (type.equals("Firston")) {
                    try {
                        String firston = params[1];
                        String firstoff = params[2];
                        URL url = new URL(firston_url);
                        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                        httpURLConnection.setRequestMethod("POST");
                        httpURLConnection.setDoOutput(true);
                        httpURLConnection.setDoInput(true);
                        OutputStream outputStream = httpURLConnection.getOutputStream();
                        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                        String post_data = URLEncoder.encode("first_on", "UTF-8") + "=" + URLEncoder.encode(firston, "UTF-8") + "&"
                                + URLEncoder.encode("first_off", "UTF-8") + "=" + URLEncoder.encode(firstoff, "UTF-8") + "&"
                                + URLEncoder.encode("user_name", "UTF-8") + "=" + URLEncoder.encode(BackgroundWorker.username, "UTF-8");
                        bufferedWriter.write(post_data);

                        bufferedWriter.flush();
                        bufferedWriter.close();
                        outputStream.close();
                        InputStream inputStream = httpURLConnection.getInputStream();
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                        String result = "";
                        String line = "";
                        while ((line = bufferedReader.readLine()) != null) {
                            result += line;
                        }
                        bufferedReader.close();
                        inputStream.close();
                        httpURLConnection.disconnect();
                        return result;
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                } else if (type.equals("Firstoff")) {
                    try {
                        String firston = params[1];
                        String firstoff = params[2];
                        URL url = new URL(firstoff_url);
                        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                        httpURLConnection.setRequestMethod("POST");
                        httpURLConnection.setDoOutput(true);
                        httpURLConnection.setDoInput(true);
                        OutputStream outputStream = httpURLConnection.getOutputStream();
                        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                        String post_data = URLEncoder.encode("first_on", "UTF-8") + "=" + URLEncoder.encode(firston, "UTF-8") + "&"
                                + URLEncoder.encode("first_off", "UTF-8") + "=" + URLEncoder.encode(firstoff, "UTF-8") + "&"
                                + URLEncoder.encode("user_name", "UTF-8") + "=" + URLEncoder.encode(BackgroundWorker.username, "UTF-8");
                        bufferedWriter.write(post_data);

                        bufferedWriter.flush();
                        bufferedWriter.close();
                        outputStream.close();
                        InputStream inputStream = httpURLConnection.getInputStream();
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                        String result = "";
                        String line = "";
                        while ((line = bufferedReader.readLine()) != null) {
                            result += line;
                        }
                        bufferedReader.close();
                        inputStream.close();
                        httpURLConnection.disconnect();
                        return result;
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                } else if (type.equals("Heatmain")) {
                    try {
                        String heat = params[1];
                        String cool = params[2];
                        String off = params[3];
                        URL url = new URL(heatmain_url);
                        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                        httpURLConnection.setRequestMethod("POST");
                        httpURLConnection.setDoOutput(true);
                        httpURLConnection.setDoInput(true);
                        OutputStream outputStream = httpURLConnection.getOutputStream();
                        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                        String post_data = URLEncoder.encode("heat", "UTF-8") + "=" + URLEncoder.encode(heat, "UTF-8") + "&"
                                + URLEncoder.encode("cool", "UTF-8") + "=" + URLEncoder.encode(cool, "UTF-8") + "&"
                                + URLEncoder.encode("off", "UTF-8") + "=" + URLEncoder.encode(off, "UTF-8") + "&"
                                + URLEncoder.encode("user_name", "UTF-8") + "=" + URLEncoder.encode(BackgroundWorker.username, "UTF-8");
                        bufferedWriter.write(post_data);

                        bufferedWriter.flush();
                        bufferedWriter.close();
                        outputStream.close();
                        InputStream inputStream = httpURLConnection.getInputStream();
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                        String result = "";
                        String line = "";
                        while ((line = bufferedReader.readLine()) != null) {
                            result += line;
                        }
                        bufferedReader.close();
                        inputStream.close();
                        httpURLConnection.disconnect();
                        return result;
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                } else if (type.equals("Coolmain")) {
                    try {
                        String heat = params[1];
                        String cool = params[2];
                        String off = params[3];
                        URL url = new URL(coolmain_url);
                        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                        httpURLConnection.setRequestMethod("POST");
                        httpURLConnection.setDoOutput(true);
                        httpURLConnection.setDoInput(true);
                        OutputStream outputStream = httpURLConnection.getOutputStream();
                        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                        String post_data = URLEncoder.encode("heat", "UTF-8") + "=" + URLEncoder.encode(heat, "UTF-8") + "&"
                                + URLEncoder.encode("cool", "UTF-8") + "=" + URLEncoder.encode(cool, "UTF-8") + "&"
                                + URLEncoder.encode("off", "UTF-8") + "=" + URLEncoder.encode(off, "UTF-8") + "&"
                                + URLEncoder.encode("user_name", "UTF-8") + "=" + URLEncoder.encode(BackgroundWorker.username, "UTF-8");
                        bufferedWriter.write(post_data);

                        bufferedWriter.flush();
                        bufferedWriter.close();
                        outputStream.close();
                        InputStream inputStream = httpURLConnection.getInputStream();
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                        String result = "";
                        String line = "";
                        while ((line = bufferedReader.readLine()) != null) {
                            result += line;
                        }
                        bufferedReader.close();
                        inputStream.close();
                        httpURLConnection.disconnect();
                        return result;
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                } else if (type.equals("Offmain")) {
                    try {
                        String heat = params[1];
                        String cool = params[2];
                        String off = params[3];
                        URL url = new URL(offmain_url);
                        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                        httpURLConnection.setRequestMethod("POST");
                        httpURLConnection.setDoOutput(true);
                        httpURLConnection.setDoInput(true);
                        OutputStream outputStream = httpURLConnection.getOutputStream();
                        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                        String post_data = URLEncoder.encode("heat", "UTF-8") + "=" + URLEncoder.encode(heat, "UTF-8") + "&"
                                + URLEncoder.encode("cool", "UTF-8") + "=" + URLEncoder.encode(cool, "UTF-8") + "&"
                                + URLEncoder.encode("off", "UTF-8") + "=" + URLEncoder.encode(off, "UTF-8") + "&"
                                + URLEncoder.encode("user_name", "UTF-8") + "=" + URLEncoder.encode(BackgroundWorker.username, "UTF-8");
                        bufferedWriter.write(post_data);

                        bufferedWriter.flush();
                        bufferedWriter.close();
                        outputStream.close();
                        InputStream inputStream = httpURLConnection.getInputStream();
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                        String result = "";
                        String line = "";
                        while ((line = bufferedReader.readLine()) != null) {
                            result += line;
                        }
                        bufferedReader.close();
                        inputStream.close();
                        httpURLConnection.disconnect();
                        return result;
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                } else if (type.equals("Fanonmain")) {
                    try {
                        String fan_off = params[1];
                        String fan_auto = params[2];
                        String fan_on = params[3];
                        URL url = new URL(fanonmain_url);
                        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                        httpURLConnection.setRequestMethod("POST");
                        httpURLConnection.setDoOutput(true);
                        httpURLConnection.setDoInput(true);
                        OutputStream outputStream = httpURLConnection.getOutputStream();
                        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                        String post_data = URLEncoder.encode("fan_off", "UTF-8") + "=" + URLEncoder.encode(fan_off, "UTF-8") + "&"
                                + URLEncoder.encode("fan_auto", "UTF-8") + "=" + URLEncoder.encode(fan_auto, "UTF-8") + "&"
                                + URLEncoder.encode("fan_on", "UTF-8") + "=" + URLEncoder.encode(fan_on, "UTF-8") + "&"
                                + URLEncoder.encode("user_name", "UTF-8") + "=" + URLEncoder.encode(BackgroundWorker.username, "UTF-8");
                        bufferedWriter.write(post_data);

                        bufferedWriter.flush();
                        bufferedWriter.close();
                        outputStream.close();
                        InputStream inputStream = httpURLConnection.getInputStream();
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                        String result = "";
                        String line = "";
                        while ((line = bufferedReader.readLine()) != null) {
                            result += line;
                        }
                        bufferedReader.close();
                        inputStream.close();
                        httpURLConnection.disconnect();
                        return result;
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                } else if (type.equals("Fanautomain")) {
                    try {
                        String fan_off = params[1];
                        String fan_auto = params[2];
                        String fan_on = params[3];
                        URL url = new URL(fanautomain_url);
                        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                        httpURLConnection.setRequestMethod("POST");
                        httpURLConnection.setDoOutput(true);
                        httpURLConnection.setDoInput(true);
                        OutputStream outputStream = httpURLConnection.getOutputStream();
                        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                        String post_data = URLEncoder.encode("fan_off", "UTF-8") + "=" + URLEncoder.encode(fan_off, "UTF-8") + "&"
                                + URLEncoder.encode("fan_auto", "UTF-8") + "=" + URLEncoder.encode(fan_auto, "UTF-8") + "&"
                                + URLEncoder.encode("fan_on", "UTF-8") + "=" + URLEncoder.encode(fan_on, "UTF-8") + "&"
                                + URLEncoder.encode("user_name", "UTF-8") + "=" + URLEncoder.encode(BackgroundWorker.username, "UTF-8");
                        bufferedWriter.write(post_data);

                        bufferedWriter.flush();
                        bufferedWriter.close();
                        outputStream.close();
                        InputStream inputStream = httpURLConnection.getInputStream();
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                        String result = "";
                        String line = "";
                        while ((line = bufferedReader.readLine()) != null) {
                            result += line;
                        }
                        bufferedReader.close();
                        inputStream.close();
                        httpURLConnection.disconnect();
                        return result;
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                } else if (type.equals("Fanoffmain")) {
                    try {
                        String fan_off = params[1];
                        String fan_auto = params[2];
                        String fan_on = params[3];
                        URL url = new URL(fanoffmain_url);
                        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                        httpURLConnection.setRequestMethod("POST");
                        httpURLConnection.setDoOutput(true);
                        httpURLConnection.setDoInput(true);
                        OutputStream outputStream = httpURLConnection.getOutputStream();
                        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                        String post_data = URLEncoder.encode("fan_off", "UTF-8") + "=" + URLEncoder.encode(fan_off, "UTF-8") + "&"
                                + URLEncoder.encode("fan_auto", "UTF-8") + "=" + URLEncoder.encode(fan_auto, "UTF-8") + "&"
                                + URLEncoder.encode("fan_on", "UTF-8") + "=" + URLEncoder.encode(fan_on, "UTF-8") + "&"
                                + URLEncoder.encode("user_name", "UTF-8") + "=" + URLEncoder.encode(BackgroundWorker.username, "UTF-8");
                        bufferedWriter.write(post_data);

                        bufferedWriter.flush();
                        bufferedWriter.close();
                        outputStream.close();
                        InputStream inputStream = httpURLConnection.getInputStream();
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                        String result = "";
                        String line = "";
                        while ((line = bufferedReader.readLine()) != null) {
                            result += line;
                        }
                        bufferedReader.close();
                        inputStream.close();
                        httpURLConnection.disconnect();
                        return result;
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                } else if (type.equals("Heatfirst")) {
                    try {
                        String heat = params[1];
                        String cool = params[2];
                        String off = params[3];
                        URL url = new URL(heatfirst_url);
                        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                        httpURLConnection.setRequestMethod("POST");
                        httpURLConnection.setDoOutput(true);
                        httpURLConnection.setDoInput(true);
                        OutputStream outputStream = httpURLConnection.getOutputStream();
                        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                        String post_data = URLEncoder.encode("heat", "UTF-8") + "=" + URLEncoder.encode(heat, "UTF-8") + "&"
                                + URLEncoder.encode("cool", "UTF-8") + "=" + URLEncoder.encode(cool, "UTF-8") + "&"
                                + URLEncoder.encode("off", "UTF-8") + "=" + URLEncoder.encode(off, "UTF-8") + "&"
                                + URLEncoder.encode("user_name", "UTF-8") + "=" + URLEncoder.encode(BackgroundWorker.username, "UTF-8");
                        bufferedWriter.write(post_data);

                        bufferedWriter.flush();
                        bufferedWriter.close();
                        outputStream.close();
                        InputStream inputStream = httpURLConnection.getInputStream();
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                        String result = "";
                        String line = "";
                        while ((line = bufferedReader.readLine()) != null) {
                            result += line;
                        }
                        bufferedReader.close();
                        inputStream.close();
                        httpURLConnection.disconnect();
                        return result;
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                } else if (type.equals("Coolfirst")) {
                    try {
                        String heat = params[1];
                        String cool = params[2];
                        String off = params[3];
                        URL url = new URL(coolfirst_url);
                        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                        httpURLConnection.setRequestMethod("POST");
                        httpURLConnection.setDoOutput(true);
                        httpURLConnection.setDoInput(true);
                        OutputStream outputStream = httpURLConnection.getOutputStream();
                        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                        String post_data = URLEncoder.encode("heat", "UTF-8") + "=" + URLEncoder.encode(heat, "UTF-8") + "&"
                                + URLEncoder.encode("cool", "UTF-8") + "=" + URLEncoder.encode(cool, "UTF-8") + "&"
                                + URLEncoder.encode("off", "UTF-8") + "=" + URLEncoder.encode(off, "UTF-8") + "&"
                                + URLEncoder.encode("user_name", "UTF-8") + "=" + URLEncoder.encode(BackgroundWorker.username, "UTF-8");
                        bufferedWriter.write(post_data);

                        bufferedWriter.flush();
                        bufferedWriter.close();
                        outputStream.close();
                        InputStream inputStream = httpURLConnection.getInputStream();
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                        String result = "";
                        String line = "";
                        while ((line = bufferedReader.readLine()) != null) {
                            result += line;
                        }
                        bufferedReader.close();
                        inputStream.close();
                        httpURLConnection.disconnect();
                        return result;
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                } else if (type.equals("Offfirst")) {
                    try {
                        String heat = params[1];
                        String cool = params[2];
                        String off = params[3];
                        URL url = new URL(offfirst_url);
                        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                        httpURLConnection.setRequestMethod("POST");
                        httpURLConnection.setDoOutput(true);
                        httpURLConnection.setDoInput(true);
                        OutputStream outputStream = httpURLConnection.getOutputStream();
                        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                        String post_data = URLEncoder.encode("heat", "UTF-8") + "=" + URLEncoder.encode(heat, "UTF-8") + "&"
                                + URLEncoder.encode("cool", "UTF-8") + "=" + URLEncoder.encode(cool, "UTF-8") + "&"
                                + URLEncoder.encode("off", "UTF-8") + "=" + URLEncoder.encode(off, "UTF-8") + "&"
                                + URLEncoder.encode("user_name", "UTF-8") + "=" + URLEncoder.encode(BackgroundWorker.username, "UTF-8");
                        bufferedWriter.write(post_data);

                        bufferedWriter.flush();
                        bufferedWriter.close();
                        outputStream.close();
                        InputStream inputStream = httpURLConnection.getInputStream();
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                        String result = "";
                        String line = "";
                        while ((line = bufferedReader.readLine()) != null) {
                            result += line;
                        }
                        bufferedReader.close();
                        inputStream.close();
                        httpURLConnection.disconnect();
                        return result;
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                } else if (type.equals("Fanonfirst")) {
                    try {
                        String fan_off = params[1];
                        String fan_auto = params[2];
                        String fan_on = params[3];
                        URL url = new URL(fanonfirst_url);
                        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                        httpURLConnection.setRequestMethod("POST");
                        httpURLConnection.setDoOutput(true);
                        httpURLConnection.setDoInput(true);
                        OutputStream outputStream = httpURLConnection.getOutputStream();
                        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                        String post_data = URLEncoder.encode("fan_off", "UTF-8") + "=" + URLEncoder.encode(fan_off, "UTF-8") + "&"
                                + URLEncoder.encode("fan_auto", "UTF-8") + "=" + URLEncoder.encode(fan_auto, "UTF-8") + "&"
                                + URLEncoder.encode("fan_on", "UTF-8") + "=" + URLEncoder.encode(fan_on, "UTF-8") + "&"
                                + URLEncoder.encode("user_name", "UTF-8") + "=" + URLEncoder.encode(BackgroundWorker.username, "UTF-8");
                        bufferedWriter.write(post_data);

                        bufferedWriter.flush();
                        bufferedWriter.close();
                        outputStream.close();
                        InputStream inputStream = httpURLConnection.getInputStream();
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                        String result = "";
                        String line = "";
                        while ((line = bufferedReader.readLine()) != null) {
                            result += line;
                        }
                        bufferedReader.close();
                        inputStream.close();
                        httpURLConnection.disconnect();
                        return result;
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                } else if (type.equals("Fanautofirst")) {
                    try {
                        String fan_off = params[1];
                        String fan_auto = params[2];
                        String fan_on = params[3];
                        URL url = new URL(fanautofirst_url);
                        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                        httpURLConnection.setRequestMethod("POST");
                        httpURLConnection.setDoOutput(true);
                        httpURLConnection.setDoInput(true);
                        OutputStream outputStream = httpURLConnection.getOutputStream();
                        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                        String post_data = URLEncoder.encode("fan_off", "UTF-8") + "=" + URLEncoder.encode(fan_off, "UTF-8") + "&"
                                + URLEncoder.encode("fan_auto", "UTF-8") + "=" + URLEncoder.encode(fan_auto, "UTF-8") + "&"
                                + URLEncoder.encode("fan_on", "UTF-8") + "=" + URLEncoder.encode(fan_on, "UTF-8") + "&"
                                + URLEncoder.encode("user_name", "UTF-8") + "=" + URLEncoder.encode(BackgroundWorker.username, "UTF-8");
                        bufferedWriter.write(post_data);

                        bufferedWriter.flush();
                        bufferedWriter.close();
                        outputStream.close();
                        InputStream inputStream = httpURLConnection.getInputStream();
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                        String result = "";
                        String line = "";
                        while ((line = bufferedReader.readLine()) != null) {
                            result += line;
                        }
                        bufferedReader.close();
                        inputStream.close();
                        httpURLConnection.disconnect();
                        return result;
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                } else if (type.equals("Fanofffirst")) {
                    try {
                        String fan_off = params[1];
                        String fan_auto = params[2];
                        String fan_on = params[3];
                        URL url = new URL(fanofffirst_url);
                        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                        httpURLConnection.setRequestMethod("POST");
                        httpURLConnection.setDoOutput(true);
                        httpURLConnection.setDoInput(true);
                        OutputStream outputStream = httpURLConnection.getOutputStream();
                        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                        String post_data = URLEncoder.encode("fan_off", "UTF-8") + "=" + URLEncoder.encode(fan_off, "UTF-8") + "&"
                                + URLEncoder.encode("fan_auto", "UTF-8") + "=" + URLEncoder.encode(fan_auto, "UTF-8") + "&"
                                + URLEncoder.encode("fan_on", "UTF-8") + "=" + URLEncoder.encode(fan_on, "UTF-8") + "&"
                                + URLEncoder.encode("user_name", "UTF-8") + "=" + URLEncoder.encode(BackgroundWorker.username, "UTF-8");
                        bufferedWriter.write(post_data);

                        bufferedWriter.flush();
                        bufferedWriter.close();
                        outputStream.close();
                        InputStream inputStream = httpURLConnection.getInputStream();
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                        String result = "";
                        String line = "";
                        while ((line = bufferedReader.readLine()) != null) {
                            result += line;
                        }
                        bufferedReader.close();
                        inputStream.close();
                        httpURLConnection.disconnect();
                        return result;
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }

                return null;
        }

        @Override
        protected void onPreExecute() {
            alertDialog = new AlertDialog.Builder(context).create();
            alertDialog.setTitle("Login Status");
        }

        @Override
        protected void onPostExecute(String result) {
            Log.d("After register",result);
            if(result == null)
            {
                Log.d(result, "Result was null");
                // do what you want to do
            }
            else if(result.equals("Registration Successful"))
            {
                Toast.makeText(context, result, Toast.LENGTH_LONG).show();
                Intent i = new Intent(context,FirstPage.class);
                context.startActivity(i);
            }
            else if(result.equals("afterjoin")){

                AlertDialog.Builder builderSingle = new AlertDialog.Builder(context);
                builderSingle.setTitle("Customer Data");

                final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1);
                arrayAdapter.addAll(items);

                builderSingle.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                builderSingle.setAdapter(arrayAdapter, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                     }
                });
                builderSingle.show();


            }
            else if(result.equals("lights_main"))
            {
                Intent intent = new Intent(context,LightsSettingsActivity.class);
                context.startActivity(intent);
            }
            else if(result.equals("lights_first"))
            {
                Intent intent = new Intent(context,LightsSettings1Activity.class);
                context.startActivity(intent);
            }

            else if(result.equals("Power Generator Registration Successful"))
            {
                Toast.makeText(context, result, Toast.LENGTH_LONG).show();
                Intent i = new Intent(context,PowerLoginActivity.class);
                context.startActivity(i);
            }

            else if(result.equals("Utility Company Registration Successful!!!"))
            {
                Toast.makeText(context, result, Toast.LENGTH_LONG).show();
                Intent i = new Intent(context,UtilityLoginActivity.class);
                context.startActivity(i);
            }

            else if(result.contains("login success!!!")) // msg you get from success like "Login Success"
            {
                Intent i = new Intent(context,MainMenuActivity.class);
                context.startActivity(i);
            }
            else if(result.contains("login not success!!!"))
            {
                alertDialog.setMessage(result);
                alertDialog.show();
            }
            else if(result.contains("New Power Company")) // msg you get from success like "Login Success"
            {
                Intent i = new Intent(context,PowerGenerator.class);
                context.startActivity(i);
            }
            else if(result.contains("ERROR"))
            {
                alertDialog.setMessage(result);
                alertDialog.show();
            }

            else if(result.contains("New Utility Company")) // msg you get from success like "Login Success"
            {
                Intent i = new Intent(context,Utility.class);
                context.startActivity(i);
            }
            else if(result.contains("Error"))
            {
                alertDialog.setMessage(result);
                alertDialog.show();
            }

            else if(result.contains("Disarm Initiated"))
            {
                alertDialog.setMessage(result);
                alertDialog.show();
            }
            else if(result.contains("Armaway Initiated"))
            {
                alertDialog.setMessage(result);
                alertDialog.show();
            }
            else if(result.contains("Armstay Initiated"))
            {
                alertDialog.setMessage(result);
                alertDialog.show();
            }
            else if(result.contains("Garage Door Open Initiated"))
            {
                alertDialog.setMessage(result);
                alertDialog.show();
            }
            else if(result.contains("Garage Door Close Initiated"))
            {
                alertDialog.setMessage(result);
                alertDialog.show();
            }
            else if(result.contains("Back Lock Initiated"))
            {
                alertDialog.setMessage(result);
                alertDialog.show();
            }
            else if(result.contains("Back Unlock Initiated"))
            {
                alertDialog.setMessage(result);
                alertDialog.show();
            }
            else if(result.contains("Front Lock Initiated"))
            {
                alertDialog.setMessage(result);
                alertDialog.show();
            }
            else if(result.contains("Front Unlock Initiated"))
            {
                alertDialog.setMessage(result);
                alertDialog.show();
            }
            else if(result.contains("Main Floor Door/Window Sensors On Initiated"))
            {
                alertDialog.setMessage(result);
                alertDialog.show();
            }
            else if(result.contains("Main Floor Door/Window Sensors Off Initiated"))
            {
                alertDialog.setMessage(result);
                alertDialog.show();
            }
            else if(result.contains("First Floor Door/Window Sensors On Initiated"))
            {
                alertDialog.setMessage(result);
                alertDialog.show();
            }
            else if(result.contains("First Floor Door/Window Sensors Off Initiated"))
            {
                alertDialog.setMessage(result);
                alertDialog.show();
            }
            else if(result.contains("Main Floor Heat Initiated"))
            {
                alertDialog.setMessage(result);
                alertDialog.show();
            }
            else if(result.contains("Main Floor Cool Initiated"))
            {
                alertDialog.setMessage(result);
                alertDialog.show();
            }
            else if(result.contains("Main Floor Off Initiated"))
            {
                alertDialog.setMessage(result);
                alertDialog.show();
            }
            else if(result.contains("Main Floor Fan On Initiated"))
            {
                alertDialog.setMessage(result);
                alertDialog.show();
            }
            else if(result.contains("Main Floor Fan Auto Initiated"))
            {
                alertDialog.setMessage(result);
                alertDialog.show();
            }
            else if(result.contains("Main Floor Fan Off Initiated"))
            {
                alertDialog.setMessage(result);
                alertDialog.show();
            }
            else if(result.contains("First Floor Heat Initiated"))
            {
                alertDialog.setMessage(result);
                alertDialog.show();
            }
            else if(result.contains("First Floor Cool Initiated"))
            {
                alertDialog.setMessage(result);
                alertDialog.show();
            }
            else if(result.contains("First Floor Off Initiated"))
            {
                alertDialog.setMessage(result);
                alertDialog.show();
            }
            else if(result.contains("First Floor Fan On Initiated"))
            {
                alertDialog.setMessage(result);
                alertDialog.show();
            }
            else if(result.contains("First Floor Fan Auto Initiated"))
            {
                alertDialog.setMessage(result);
                alertDialog.show();
            }
            else if(result.contains("First Floor Fan Off Initiated"))
            {
                alertDialog.setMessage(result);
                alertDialog.show();
            }
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }
    }


