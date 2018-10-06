package ThMod_FnH.cards.Marisa;

import ThMod_FnH.action.OpenUniverseAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
//import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDrawPileAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import com.megacrit.cardcrawl.vfx.cardManip.ShowCardAndAddToDrawPileEffect;

import ThMod_FnH.ThMod;
import ThMod_FnH.patches.AbstractCardEnum;
import basemod.abstracts.CustomCard;

public class OpenUniverse extends CustomCard {

  public static final String ID = "OpenUniverse";
  public static final String IMG_PATH = "img/cards/Defend.png";
  private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
  public static final String NAME = cardStrings.NAME;
  public static final String DESCRIPTION = cardStrings.DESCRIPTION;
  public static final String DESCRIPTION_UPG = cardStrings.UPGRADE_DESCRIPTION;
  private static final int COST = 1;
  private static final int DRAW = 2;

  public OpenUniverse() {
    super(
        ID, NAME, IMG_PATH,
        COST, DESCRIPTION,
        AbstractCard.CardType.SKILL,
        AbstractCardEnum.MARISA_COLOR,
        AbstractCard.CardRarity.UNCOMMON,
        AbstractCard.CardTarget.SELF
    );
    this.exhaust = true;
    this.magicNumber = this.baseMagicNumber = DRAW;
  }

  public void use(AbstractPlayer p, AbstractMonster m) {

    AbstractDungeon.actionManager.addToBottom(
        new OpenUniverseAction(this.magicNumber,this.upgraded)
    );

  }

  public AbstractCard makeCopy() {
    return new OpenUniverse();
  }

  public void upgrade() {
    if (!this.upgraded) {
      upgradeName();
      //upgradeMagicNumber(UPG_DRAW);
      this.exhaust = false;
      this.rawDescription = cardStrings.UPGRADE_DESCRIPTION;
      ;
      initializeDescription();
    }
  }

}
