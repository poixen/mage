/*
 *  Copyright 2010 BetaSteward_at_googlemail.com. All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without modification, are
 *  permitted provided that the following conditions are met:
 *
 *     1. Redistributions of source code must retain the above copyright notice, this list of
 *        conditions and the following disclaimer.
 *
 *     2. Redistributions in binary form must reproduce the above copyright notice, this list
 *        of conditions and the following disclaimer in the documentation and/or other materials
 *        provided with the distribution.
 *
 *  THIS SOFTWARE IS PROVIDED BY BetaSteward_at_googlemail.com ``AS IS'' AND ANY EXPRESS OR IMPLIED
 *  WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 *  FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL BetaSteward_at_googlemail.com OR
 *  CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 *  CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 *  SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 *  ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 *  NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
 *  ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 *  The views and conclusions contained in the software and documentation are those of the
 *  authors and should not be interpreted as representing official policies, either expressed
 *  or implied, of BetaSteward_at_googlemail.com.
 */

package mage.sets.alarareborn;

import java.util.UUID;
import mage.abilities.Ability;
import mage.constants.CardType;
import mage.constants.Rarity;
import mage.abilities.common.EntersBattlefieldTappedAbility;
import mage.abilities.costs.AlternativeCostSourceAbility;
import mage.abilities.costs.common.ReturnToHandChosenControlledPermanentCost;
import mage.abilities.costs.mana.GenericManaCost;
import mage.abilities.mana.GreenManaAbility;
import mage.abilities.mana.WhiteManaAbility;
import mage.cards.CardImpl;
import mage.filter.common.FilterControlledLandPermanent;
import mage.filter.common.FilterControlledPermanent;
import mage.filter.predicate.mageobject.SupertypePredicate;
import mage.target.common.TargetControlledPermanent;

/**
 *
 * @author Loki
 */
public class WildfieldBorderpost extends CardImpl {

    private static final FilterControlledPermanent filter = new FilterControlledLandPermanent("a basic land");

    static {
        filter.add(new SupertypePredicate("Basic"));
    }

    public WildfieldBorderpost (UUID ownerId) {
        super(ownerId, 80, "Wildfield Borderpost", Rarity.COMMON, new CardType[]{CardType.ARTIFACT}, "{1}{G}{W}");
        this.expansionSetCode = "ARB";



        // You may pay {1} and return a basic land you control to its owner's hand rather than pay Wildfield Borderpost's mana cost.
        Ability ability = new AlternativeCostSourceAbility(new GenericManaCost(1));
        ability.addCost(new ReturnToHandChosenControlledPermanentCost(new TargetControlledPermanent(filter)));
        this.addAbility(ability);

        // Wildfield Borderpost enters the battlefield tapped.
        this.addAbility(new EntersBattlefieldTappedAbility());

        // {T}: Add {G} or {W} to your mana pool.
        this.addAbility(new GreenManaAbility());
        this.addAbility(new WhiteManaAbility());
    }

    public WildfieldBorderpost (final WildfieldBorderpost card) {
        super(card);
    }

    @Override
    public WildfieldBorderpost copy() {
        return new WildfieldBorderpost(this);
    }

}
