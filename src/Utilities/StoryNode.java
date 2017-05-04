package Utilities;

import Json.JSONArray;
import Json.JSONObject;
import Json.JSONTokener;

/**
 * Created by Leonardo Baldin on 30/04/17.
 */

public class StoryNode {

    private String domanda;
    private String scelta1;
    private String scelta2;

    private int nextIndex1;
    private int nextIndex2;
    
    private int storyIndex1;
    private int storyIndex2;

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

    public int getStoryIndex1() {
        return storyIndex1;
    }

    public int getStoryIndex2() {
        return storyIndex2;
    }

    public StoryNode(String domanda, String scelta1, String scelta2, int nextIndex1, int nextIndex2, int storyIndex1, int storyIndex2) {
        this.domanda = domanda;
        this.scelta1 = scelta1;
        this.scelta2 = scelta2;
        this.nextIndex1 = nextIndex1;
        this.nextIndex2 = nextIndex2;
        this.storyIndex1 = storyIndex1;
        this.storyIndex2 = storyIndex2;
    }

    @Override
    public String toString() {
        return "Domanda: " + domanda;
    }


    public StoryNode getNextStoryNode(int scelta) {
        JSONObject jsonChoice = null;
        if (scelta == 1) {
            jsonChoice = new Json().getChoices().getJSONObject(getNextIndex1());
        } else if (scelta == 2) {
            jsonChoice = new Json().getChoices().getJSONObject(getNextIndex2());
        } else throw new IndexOutOfBoundsException("int scelta non è né 1 né 2!");

        return new StoryNode(
                jsonChoice.getString("domanda"),
                jsonChoice.getString("scelta1"),
                jsonChoice.getString("scelta2"),
                jsonChoice.getInt("nextIndex1"),
                jsonChoice.getInt("nextIndex2"),
                jsonChoice.getInt("storyIndex1"),
                jsonChoice.getInt("storyIndex2")
        );
    }

    public String getNextStoryText(int scelta) {
        if (scelta == 1) {
            return new Json().getStories().getString(getNextIndex1());
        } else if (scelta == 2) {
            return new Json().getStories().getString(getNextIndex2());
        } else throw new IndexOutOfBoundsException("int scelta non è né 1 né 2!");

    }

    /**
     * La classe interna Json (è anche statica!) serve a ottenere singoli oggetti da story.json
     * e convertirli in oggetti StoryNode, contenenti la domanda e le due scelte sotto forma di stringhe.
     */
    public class Json {

        private static final String JSON_FILE = "/Resources/story.json";
        private JSONTokener tokener = null;
        private JSONObject story;
        private JSONArray choices;
        private JSONArray stories;

        public Json() {
            // tokener è un oggetto che legge il file json
            tokener = new JSONTokener(getClass().getResourceAsStream(JSON_FILE));

            // Il file viene trasformato in un oggetto per facilitare accesso ed estrazione delle scelte
            story = new JSONObject(tokener);
            // getJSONArray estrae dall'oggetto json l'array "choices"
            choices = story.getJSONArray("choices");
            stories = story.getJSONArray("stories");
        }

        /**
         * getChoice legge dall'array all'indice indicato e crea un oggetto StoryNode che contiene i valori estratti
         * dal json
         */
        public StoryNode getStoryNode(int index) {
            JSONObject jsonChoice = choices.getJSONObject(index);
            return new StoryNode(
                    jsonChoice.getString("domanda"),
                    jsonChoice.getString("scelta1"),
                    jsonChoice.getString("scelta2"),
                    jsonChoice.getInt("nextIndex1"),
                    jsonChoice.getInt("nextIndex2"),
                    jsonChoice.getInt("storyIndex1"),
                    jsonChoice.getInt("storyIndex2")
            );
        }

        public JSONArray getChoices() {
            return choices;
        }

        public JSONArray getStories() {
            return stories;
        }
    }

}
