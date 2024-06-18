package enums;

import lombok.Getter;

public enum Endpoints {

    ALERT("/alerts"),
    FRAMES("/frames"),
    BUTTONS("/buttons"),
PROGRESSBAR("/progress-bar"),
    PRACTICEFORM("/automation-practice-form");
    @Getter
    String endpoint;

    Endpoints(String endpoint){
        this.endpoint = endpoint;
    }
        }
