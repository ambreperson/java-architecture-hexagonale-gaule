package gaule.village.javanoramix.domain.adapter;

import gaule.village.javanoramix.domain.druide.notif.Notificateur;

public class NotifierSpy implements Notificateur {
    public int count = 0;

    @Override
    public void notifier(String message) {
        count++;
    }
}
