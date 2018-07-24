package com.hi.floatingbuttonmenu;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;
import com.hi.floatingbuttonmenu.fragment.AlaramFragment;
import com.hi.floatingbuttonmenu.fragment.CelestialFragment;
import com.hi.floatingbuttonmenu.fragment.ContentFragment;
import com.hi.floatingbuttonmenu.fragment.DisplayFragment;
import com.hi.floatingbuttonmenu.fragment.EBFragment;
import com.hi.floatingbuttonmenu.fragment.FlightFragment;
import com.hi.floatingbuttonmenu.fragment.MessageFragment;
import com.hi.floatingbuttonmenu.fragment.RouteFragment;
import com.hi.floatingbuttonmenu.fragment.SetupFragment;
import com.hi.floatingbuttonmenu.fragment.SoundFragment;
import com.hi.floatingbuttonmenu.fragment.aircraftfragmentpackage.AircraftFragment;

import com.hi.floatingbuttonmenu.fragment.gpsfragmentpackge.GPSFragment;
import com.hi.floatingbuttonmenu.fragment.pointfragmentpackage.PointsFragment;
import com.hi.floatingbuttonmenu.fragment.trackfragmentpackage.TrackFragment;
import com.hitomi.cmlibrary.CircleMenu;
import com.hitomi.cmlibrary.OnMenuSelectedListener;
import com.nightonke.boommenu.BoomMenuButton;

import java.util.ArrayList;
import java.util.List;

import io.codetail.animation.SupportAnimator;
import io.codetail.animation.ViewAnimationUtils;
import yalantis.com.sidemenu.interfaces.Resourceble;
import yalantis.com.sidemenu.interfaces.ScreenShotable;
import yalantis.com.sidemenu.model.SlideMenuItem;
import yalantis.com.sidemenu.util.ViewAnimator;

public class MainActivity extends AppCompatActivity implements ViewAnimator.ViewAnimatorListener {
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerToggle;
    private List<SlideMenuItem> list = new ArrayList<>();
    private ContentFragment contentFragment;
    private ViewAnimator viewAnimator;

    private LinearLayout linearLayout;
    String arrayName[] ={"GPS","FILGHT","ROUTE","POINT","TRACK","AIRCRAFT","ALARAM","MESSAGE","DISPLAY","SOUND","SETUP"};
    private static final String BACK_STACK_ROOT_TAG = "root_fragment";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contentFragment = ContentFragment.newInstance(R.drawable.kestrel_logo);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content_frame, contentFragment)
                .commit();
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerLayout.setScrimColor(Color.TRANSPARENT);
        linearLayout = (LinearLayout) findViewById(R.id.left_drawer);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawers();
            }
        });


        setActionBar();
        createMenuList();
        viewAnimator = new ViewAnimator<>(this, list, contentFragment, drawerLayout, this);
    }
    private void createMenuList() {
        SlideMenuItem menuItem0 = new SlideMenuItem(ContentFragment.CLOSE, R.drawable.icn_close);
        list.add(menuItem0);
        SlideMenuItem menuItem1= new SlideMenuItem(ContentFragment.GPS, R.drawable.gps);
        list.add(menuItem1);
        SlideMenuItem menuItem2 = new SlideMenuItem(ContentFragment.Flight, R.drawable.flights);
        list.add(menuItem2);
        SlideMenuItem menuItem3 = new SlideMenuItem(ContentFragment.Route, R.drawable.routes);
        list.add(menuItem3);
        SlideMenuItem menuItem4 = new SlideMenuItem(ContentFragment.Point, R.drawable.point);
        list.add(menuItem4);
        SlideMenuItem menuItem5 = new SlideMenuItem(ContentFragment.Track, R.drawable.track);
        list.add(menuItem5);
        SlideMenuItem menuItem6 = new SlideMenuItem(ContentFragment.Aircraft, R.drawable.aircraft);
        list.add(menuItem6);
        SlideMenuItem menuItem7 = new SlideMenuItem(ContentFragment.EB, R.drawable.eb);
        list.add(menuItem7);
        SlideMenuItem menuItem8 = new SlideMenuItem(ContentFragment.Alaram,R.drawable.alarm);
        list.add(menuItem8);
        SlideMenuItem menuItem9 = new SlideMenuItem(ContentFragment.Celesitial,R.drawable.celestial);
        list.add(menuItem9);
        SlideMenuItem menuItem10 = new SlideMenuItem(ContentFragment.Message,R.drawable.message);
        list.add(menuItem10);
        SlideMenuItem menuItem11 = new SlideMenuItem(ContentFragment.Display,R.drawable.display);
        list.add(menuItem11);
        SlideMenuItem menuItem12 = new SlideMenuItem(ContentFragment.Sound,R.drawable.sound);
        list.add(menuItem12);
        SlideMenuItem menuItem13 = new SlideMenuItem(ContentFragment.Setup,R.drawable.setup);
        list.add(menuItem13);

    }
    private void setActionBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(Html.fromHtml("<font color='#FFFFFF'>SideMenu </font>"));
        drawerToggle = new ActionBarDrawerToggle(
                this,                  /* host Activity */
                drawerLayout,         /* DrawerLayout object */
                toolbar,  /* nav drawer icon to replace 'Up' caret */
                R.string.drawer_open,  /* "open drawer" description */
                R.string.drawer_close  /* "close drawer" description */
        ) {

            /** Called when a drawer has settled in a completely closed state. */
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                linearLayout.removeAllViews();
                linearLayout.invalidate();
            }
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
                if (slideOffset > 0.6 && linearLayout.getChildCount() == 0)
                    viewAnimator.showMenuContent();
            }

            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };
        drawerLayout.setDrawerListener(drawerToggle);
    }
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        switch (item.getItemId()) {
            case R.id.action_settings:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    private ScreenShotable replaceGPSFragment(ScreenShotable screenShotable,int Position){
        View view = findViewById(R.id.content_frame);
        int finalRadius = Math.max(view.getWidth(), view.getHeight());
        SupportAnimator animator = ViewAnimationUtils.createCircularReveal(view, 0, Position, 0, finalRadius);
        animator.setInterpolator(new AccelerateInterpolator());
        animator.setDuration(ViewAnimator.CIRCULAR_REVEAL_ANIMATION_DURATION);
        animator.start();
        GPSFragment gpsFragment = new GPSFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.content_frame,gpsFragment).commit();
        return gpsFragment;
    }

   private ScreenShotable replaceFlightFragment(ScreenShotable screenShotable,int Position){
        View view = findViewById(R.id.content_frame);
        int finalRadius = Math.max(view.getWidth(), view.getHeight());
        SupportAnimator animator = ViewAnimationUtils.createCircularReveal(view, 0, Position, 0, finalRadius);
        animator.setInterpolator(new AccelerateInterpolator());
        animator.setDuration(ViewAnimator.CIRCULAR_REVEAL_ANIMATION_DURATION);
        animator.start();
        FlightFragment flightFragment = new FlightFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.content_frame,flightFragment).commit();
        return flightFragment;
    }
    private ScreenShotable replaceRouteFragment(ScreenShotable screenShotable,int Position){
        View view = findViewById(R.id.content_frame);
        int finalRadius = Math.max(view.getWidth(), view.getHeight());
        SupportAnimator animator = ViewAnimationUtils.createCircularReveal(view, 0, Position, 0, finalRadius);
        animator.setInterpolator(new AccelerateInterpolator());
        animator.setDuration(ViewAnimator.CIRCULAR_REVEAL_ANIMATION_DURATION);
        animator.start();
        RouteFragment routeFragment = new RouteFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.content_frame,routeFragment).commit();
        return routeFragment;
    }
    private ScreenShotable replacePointsFragment(ScreenShotable screenShotable,int Position){
        View view = findViewById(R.id.content_frame);
        int finalRadius = Math.max(view.getWidth(), view.getHeight());
        SupportAnimator animator = ViewAnimationUtils.createCircularReveal(view, 0, Position, 0, finalRadius);
        animator.setInterpolator(new AccelerateInterpolator());
        animator.setDuration(ViewAnimator.CIRCULAR_REVEAL_ANIMATION_DURATION);
        animator.start();
        PointsFragment pointsFragment = new PointsFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.content_frame,pointsFragment).commit();
        return pointsFragment;
    }
    private ScreenShotable replaceTrackFragment(ScreenShotable screenShotable,int Position){
        View view = findViewById(R.id.content_frame);
        int finalRadius = Math.max(view.getWidth(), view.getHeight());
        SupportAnimator animator = ViewAnimationUtils.createCircularReveal(view, 0, Position, 0, finalRadius);
        animator.setInterpolator(new AccelerateInterpolator());
        animator.setDuration(ViewAnimator.CIRCULAR_REVEAL_ANIMATION_DURATION);
        animator.start();
        TrackFragment trackFragment = new TrackFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.content_frame,trackFragment).commit();
        return trackFragment;
    }
    private ScreenShotable replaceAircraftFragment(ScreenShotable screenShotable,int Position){
        View view = findViewById(R.id.content_frame);
        int finalRadius = Math.max(view.getWidth(), view.getHeight());
        SupportAnimator animator = ViewAnimationUtils.createCircularReveal(view, 0, Position, 0, finalRadius);
        animator.setInterpolator(new AccelerateInterpolator());
        animator.setDuration(ViewAnimator.CIRCULAR_REVEAL_ANIMATION_DURATION);
        animator.start();
        AircraftFragment aircraftFragment = new AircraftFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.content_frame,aircraftFragment).commit();
        return aircraftFragment;
    }
    private ScreenShotable replaceE6BFragment(ScreenShotable screenShotable,int Position){
        View view = findViewById(R.id.content_frame);
        int finalRadius = Math.max(view.getWidth(), view.getHeight());
        SupportAnimator animator = ViewAnimationUtils.createCircularReveal(view, 0, Position, 0, finalRadius);
        animator.setInterpolator(new AccelerateInterpolator());
        animator.setDuration(ViewAnimator.CIRCULAR_REVEAL_ANIMATION_DURATION);
        animator.start();
        EBFragment ebFragment = new EBFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.content_frame,ebFragment).commit();
        return ebFragment;
    }
    private ScreenShotable replaceAlaramFragment(ScreenShotable screenShotable,int Position){
        View view = findViewById(R.id.content_frame);
        int finalRadius = Math.max(view.getWidth(), view.getHeight());
        SupportAnimator animator = ViewAnimationUtils.createCircularReveal(view, 0, Position, 0, finalRadius);
        animator.setInterpolator(new AccelerateInterpolator());
        animator.setDuration(ViewAnimator.CIRCULAR_REVEAL_ANIMATION_DURATION);
        animator.start();
        AlaramFragment alaramFragment = new AlaramFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.content_frame,alaramFragment).commit();
        return alaramFragment;
    }
    private ScreenShotable replaceCelestialFragment(ScreenShotable screenShotable,int Position){
        View view = findViewById(R.id.content_frame);
        int finalRadius = Math.max(view.getWidth(), view.getHeight());
        SupportAnimator animator = ViewAnimationUtils.createCircularReveal(view, 0, Position, 0, finalRadius);
        animator.setInterpolator(new AccelerateInterpolator());
        animator.setDuration(ViewAnimator.CIRCULAR_REVEAL_ANIMATION_DURATION);
        animator.start();
        CelestialFragment celestialFragment = new CelestialFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.content_frame,celestialFragment).commit();
        return celestialFragment;
    }
    private ScreenShotable replaceMessageFragment(ScreenShotable screenShotable,int Position){
        View view = findViewById(R.id.content_frame);
        int finalRadius = Math.max(view.getWidth(), view.getHeight());
        SupportAnimator animator = ViewAnimationUtils.createCircularReveal(view, 0, Position, 0, finalRadius);
        animator.setInterpolator(new AccelerateInterpolator());
        animator.setDuration(ViewAnimator.CIRCULAR_REVEAL_ANIMATION_DURATION);
        animator.start();
        MessageFragment messageFragment = new MessageFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.content_frame,messageFragment).commit();
        return messageFragment;
    }
    private ScreenShotable replaceDisplayFragment(ScreenShotable screenShotable,int Position){
        View view = findViewById(R.id.content_frame);
        int finalRadius = Math.max(view.getWidth(), view.getHeight());
        SupportAnimator animator = ViewAnimationUtils.createCircularReveal(view, 0, Position, 0, finalRadius);
        animator.setInterpolator(new AccelerateInterpolator());
        animator.setDuration(ViewAnimator.CIRCULAR_REVEAL_ANIMATION_DURATION);
        animator.start();
        DisplayFragment displayFragment = new DisplayFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.content_frame,displayFragment).commit();
        return displayFragment;
    }
    private ScreenShotable replaceSoundFragment(ScreenShotable screenShotable,int Position){
        View view = findViewById(R.id.content_frame);
        int finalRadius = Math.max(view.getWidth(), view.getHeight());
        SupportAnimator animator = ViewAnimationUtils.createCircularReveal(view, 0, Position, 0, finalRadius);
        animator.setInterpolator(new AccelerateInterpolator());
        animator.setDuration(ViewAnimator.CIRCULAR_REVEAL_ANIMATION_DURATION);
        animator.start();
        SoundFragment soundFragment = new SoundFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.content_frame,soundFragment).commit();
        return soundFragment;
    }
    private ScreenShotable replaceSetupFragment(ScreenShotable screenShotable,int Position){
        View view = findViewById(R.id.content_frame);
        int finalRadius = Math.max(view.getWidth(), view.getHeight());
        SupportAnimator animator = ViewAnimationUtils.createCircularReveal(view, 0, Position, 0, finalRadius);
        animator.setInterpolator(new AccelerateInterpolator());
        animator.setDuration(ViewAnimator.CIRCULAR_REVEAL_ANIMATION_DURATION);
        animator.start();
        SetupFragment setupFragment = new SetupFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.content_frame,setupFragment).commit();
        return setupFragment;
    }

    @Override
    public ScreenShotable onSwitch(Resourceble slideMenuItem, ScreenShotable screenShotable, int position) {
        switch (slideMenuItem.getName()){
            case ContentFragment.CLOSE:
                return replaceGPSFragment(screenShotable, position);
            case ContentFragment.GPS:
                return replaceGPSFragment(screenShotable, position);
            case ContentFragment.Flight:
                return replaceFlightFragment(screenShotable,position);
            case ContentFragment.Route:
                return replaceRouteFragment(screenShotable,position);
            case ContentFragment.Track:
                return replaceTrackFragment(screenShotable,position);
            case ContentFragment.Point:
                return replacePointsFragment(screenShotable,position);
            case ContentFragment.Aircraft:
                return replaceAircraftFragment(screenShotable,position);
            case ContentFragment.EB:
                return replaceE6BFragment(screenShotable,position);
            case ContentFragment.Alaram:
                return replaceAlaramFragment(screenShotable,position);
            case ContentFragment.Celesitial:
                return replaceCelestialFragment(screenShotable,position);
            case ContentFragment.Message:
                return replaceMessageFragment(screenShotable,position);
            case ContentFragment.Display:
                return replaceDisplayFragment(screenShotable,position);
            case ContentFragment.Sound:
                return replaceSoundFragment(screenShotable,position);
            case ContentFragment.Setup:
                return replaceSetupFragment(screenShotable,position);
            default:
                return replaceGPSFragment(screenShotable, position);
        }
    }

    @Override
    public void disableHomeButton() {
        getSupportActionBar().setHomeButtonEnabled(false);
    }

    @Override
    public void enableHomeButton() {
        getSupportActionBar().setHomeButtonEnabled(true);
        drawerLayout.closeDrawers();
    }

    @Override
    public void addViewToContainer(View view) {
        linearLayout.addView(view);
    }
}
