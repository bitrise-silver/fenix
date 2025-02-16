/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

package org.mozilla.fenix

import android.content.Context
import mozilla.components.support.locale.LocaleManager
import mozilla.components.support.locale.LocaleManager.getSystemDefault

/**
 * A single source for setting feature flags that are mostly based on build type.
 */
object FeatureFlags {

    /**
     * Enables custom extension collection feature,
     * This feature does not only depend on this flag. It requires the AMO collection override to
     * be enabled which is behind the Secret Settings.
     * */
    val customExtensionCollectionFeature = Config.channel.isNightlyOrDebug || Config.channel.isBeta

    /**
     * Pull-to-refresh allows you to pull the web content down far enough to have the page to
     * reload.
     */
    val pullToRefreshEnabled = Config.channel.isNightlyOrDebug

    /**
     * Enables the Sync Addresses feature.
     */
    const val syncAddressesFeature = false

    /**
     * Enables the onboarding sync CFR on the home screen.
     */
    const val showSynCFR = true

    /**
     * Enables the onboarding jump back in CFR on the home screen.
     */
    const val showJumpBackInCFR = true

    /**
     * Enables the first run onboarding updates.
     */
    const val showFirstRunOnboardingUpdates = false

    /**
     * Enables the "recent" tabs feature in the home screen.
     */
    const val showRecentTabsFeature = true

    /**
     * Enables UI features based on history metadata.
     */
    const val historyMetadataUIFeature = true

    /**
     * Enables the recently saved bookmarks feature in the home screen.
     */
    const val recentBookmarksFeature = true

    /**
     * Identifies and separates the tabs list with a secondary section containing least used tabs.
     */
    const val inactiveTabs = true

    /**
     * Show Pocket recommended stories on home.
     */
    fun isPocketRecommendationsFeatureEnabled(context: Context): Boolean {
        val langTag = LocaleManager.getCurrentLocale(context)
            ?.toLanguageTag() ?: getSystemDefault().toLanguageTag()
        return listOf("en-US", "en-CA").contains(langTag)
    }

    /**
     * Show Pocket sponsored stories in between Pocket recommended stories on home.
     */
    fun isPocketSponsoredStoriesFeatureEnabled(context: Context): Boolean {
        return isPocketRecommendationsFeatureEnabled(context) && Config.channel.isDebug
    }

    /**
     * Enables showing the homescreen onboarding card.
     */
    const val showHomeOnboarding = true

    /**
     * Enables the Task Continuity enhancements.
     */
    const val taskContinuityFeature = true

    /**
     * Enables the Unified Search feature.
     */
    val unifiedSearchFeature = Config.channel.isNightlyOrDebug

    /**
     * Enables receiving from the messaging framework.
     */
    const val messagingFeature = true

    /**
     * Enables compose on the tabs tray items.
     */
    val composeTabsTray = Config.channel.isDebug

    /**
     * Enables the wallpaper onboarding.
     */
    const val wallpaperOnboardingEnabled = true

    /**
     * Enables the wallpaper v2 enhancements.
     */
    const val wallpaperV2Enabled = true

    /**
     * Enables the save to PDF feature.
     */
    const val saveToPDF = true

    /**
     * Enables storage maintenance feature
     * */
    val storageMaintenanceFeature = Config.channel.isNightlyOrDebug
}
