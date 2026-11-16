package gaule.village.javanoramix.domain.druide;

import gaule.village.javanoramix.domain.druide.notif.Notificateur;

public class NotificateurSpy implements Notificateur {
    private int callCount = 0;

    public int getCallCount() {
        return this.callCount;
    }

    @Override
    public void notifier(String message) {
        this.callCount++;
    }
}
