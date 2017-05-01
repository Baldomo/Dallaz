package Utilities;

import Json.JSONArray;
import Json.JSONObject;
import Json.JSONTokener;

/**
 * Created by Leonardo Baldin on 30/04/17.
 */

public class Choice {

    private String domanda;
    private String scelta1;
    private String scelta2;

    private int nextIndex1;
    private int nextIndex2;

    public String getDomanda() {
        return domanda;
    }

    public String getScelta1() {
        return scelta1;
    }

    public String getScelta2() {
        return scelta2;
    }

    public int getNextIndex1() {
        return nextIndex1;
    }

    public int getNextIndex2() {
        return nextIndex2;
    }

    public Choice(String domanda, String scelta1, String scelta2, int nextIndex1, int nextIndex2) {
        this.domanda = domanda;
        this.scelta1 = scelta1;
        this.scelta2 = scelta2;
        this.nextIndex1 = nextIndex1;
        this.nextIndex2 = nextIndex2;
    }

    @Override
    public String toString() {
        return "Domanda: " + domanda;
    }


    /**
     * La classe interna Json (è anche statica!) serve a ottenere singoli oggetti da story.json
     * e convertirli in oggetti Choice, contenenti la domanda e le due scelte sotto forma di stringhe.
     */
    public static class Json {

        private static final String JSON_FILE = "/Resources/story.json";
        private JSONTokener tokener = null;
        private JSONObject story;
        private JSONArray choices;

        public Json() {
            // tokener è un oggetto che legge il file json
            tokener = new JSONTokener(getClass().getResourceAsStream(JSON_FILE));

            // Il file viene trasformato in un oggetto per facilitare accesso ed estrazione delle scelte
            story = new JSONObject(tokener);
            // getJSONArray estrae dall'oggetto json l'array "choices"
            choices = story.getJSONArray("choices");
        }

        /**
         * getChoice legge dall'array all'indice indicato e crea un oggetto Choice che contiene i valori estratti
         * dal json
         */
        public Choice getChoice(int index) {
            JSONObject jsonChoice = choices.getJSONObject(index);
            return new Choice(
                    jsonChoice.getString("domanda"),
                    jsonChoice.getString("scelta1"),
                    jsonChoice.getString("scelta2"),
                    jsonChoice.getInt("nextIndex1"),
                    jsonChoice.getInt("nextIndex2")
            );
        }
    }

}
