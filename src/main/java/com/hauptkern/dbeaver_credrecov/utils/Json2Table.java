package com.hauptkern.dbeaver_credrecov.utils;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.util.ArrayList;

public class Json2Table {
    private static String rawData;

    public ArrayList<CredentialModel> convert(){
        ArrayList<CredentialModel> data = new ArrayList<>();
        JsonObject jObj = new Gson().fromJson(rawData, JsonObject.class);
        for (String key : jObj.keySet()) {
            if (jObj.get(key) instanceof JsonObject) {
                JsonObject row_data = ((JsonObject) jObj.get(key)).getAsJsonObject("#connection");
                CredentialModel row = new CredentialModel(key,row_data.get("user").getAsString(),row_data.get("password").getAsString());
                data.add(row);
            }
        }
        return data;
    }

    public Json2Table(String rawText) {
        rawData=rawText;
    }
}
