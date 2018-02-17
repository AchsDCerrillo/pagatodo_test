package com.achscerrillo.pagatodoexamen.persistence.preferences;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by alejandrocerrillo on 17/02/18.
 */

public class PreferencesFacade {

    private Context context;
    private static PreferencesFacade preferencesFacade = null;
    private static final String PREFERENCES_NAME = "PagaTodoPreferences";
    private static final String TOKEN = "Token";
    private static final String ID_USER = "id_user";
    private static final String AGENT = "agent";
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    public synchronized static PreferencesFacade getInstance(Context context) {
        if (preferencesFacade == null) {
            preferencesFacade = new PreferencesFacade(context);
        }
        return preferencesFacade;
    }

    private PreferencesFacade(Context context) {
        this.context = context;
        preferences = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
        editor = preferences.edit();
    }

    public void saveToken(String token){
        editor.putString(TOKEN, token);
        editor.commit();
    }

    public void deleteToken(){
        editor.remove(TOKEN);
        editor.commit();
    }

    public String getToken(){
        return preferences.getString(TOKEN, "");
    }

    public void saveUserId(String id){
        editor.putString(ID_USER, id);
        editor.commit();
    }

    public void deleteUserId(){
        editor.remove(ID_USER);
        editor.commit();
    }

    public String getUserId(){
        return preferences.getString(ID_USER, "");
    }

    public void saveAgent(String agent){
        editor.putString(AGENT, agent);
        editor.commit();
    }

    public void deleteAgent(){
        editor.remove(AGENT);
        editor.commit();
    }

    public String getAgent(){
        return preferences.getString(AGENT, "");
    }

}
