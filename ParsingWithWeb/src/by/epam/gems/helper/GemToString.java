package by.epam.gems.helper;

import by.epam.gems.entity.Gem;
import by.epam.gems.entity.PrivateGem;
import by.epam.gems.entity.RussianGem;

/**
 * Created by Maxim Selyuk on 20.01.16.
 */
public final class GemToString {
    public static String convert(Gem gem) {
        StringBuilder sb = new StringBuilder();
        if (gem instanceof RussianGem) {
            sb.append("RussianGem{");
        } else if (gem instanceof PrivateGem) {
            sb.append("PrivateGem{");
        }
        sb.append("id='").append(gem.getId()).append('\'');
        sb.append(", title='").append(gem.getTitle()).append('\'');
        sb.append(", name='").append(gem.getName()).append('\'');
        sb.append(", preciousness='").append(gem.getPreciousness()).append('\'');
        sb.append(", origin='").append(gem.getOrigin()).append('\'');
        /*sb.append(", visualParameters=").append(gem.getVisualParameters());*/
        sb.append(", value=").append(gem.getValue());
        if (gem instanceof RussianGem) {
            sb.append(", purchase-year=").append(((RussianGem) gem).getPurchaseYear()).append('\'');
        } else if (gem instanceof PrivateGem) {
            sb.append(", owner=").append(((PrivateGem) gem).getOwner()).append('\'');
        }
        sb.append("}\n");
        return sb.toString();
    }
}
