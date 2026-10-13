package gaule.village.javanoramix.adapters.druide;

import gaule.village.javanoramix.domain.barde.Barde;
import gaule.village.javanoramix.domain.druide.notif.Notificateur;
import org.springframework.stereotype.Service;

@Service
public class BardeAdapter implements Notificateur {
    
    private final Barde barde;

    public BardeAdapter(Barde barde) {
        this.barde = barde;
    }
    
    @Override
    public void notifier(String message) {
        barde.chanter(message);
    }
}
