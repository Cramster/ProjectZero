package org.example.Model;

public class Game {
    private String title;
    private int releaseYear;
    private String description;
    private boolean formatDigital;

    public Game(String title, int releaseYear, String description, boolean formatDigital) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.description = description;
        this.formatDigital = formatDigital;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public int getReleaseYear() {
        return releaseYear;
    }
    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

   public boolean getFormatDigital() { return formatDigital; }
    public void setFormatDigital(boolean formatDigital) { this.formatDigital = formatDigital; }

    @Override
    public String toString() {
        return "Game{" +
                "title='" + title + '\'' +
                ", releaseYear='" + releaseYear + '\'' +
                ", description='" + description + '\'' +
                ", formatDigital='" + formatDigital + '\'' +
                '}';
    }
}
