﻿using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Sound
{
    private GameObject _sounds;

    // 게임
    public AudioSource CrowdDefault { get; private set; }
    public AudioSource CrowdGoal { get; private set; }
    public AudioSource Whistle { get; private set; }
    public AudioSource KickBall { get; private set; }
    public AudioSource HitPost { get; private set; }
    public AudioSource HitFense { get; private set; }
    public AudioSource BounceBall { get; private set; }
    public AudioSource GoalNet { get; private set; }
    public AudioSource EndWhistle { get; private set; }

    // 로비


    public Sound(bool isGameScene)
    {
        _sounds = GameObject.Find("Sounds");

        // 게임
        if(isGameScene)
        {
            CrowdDefault = _sounds.transform.Find("Crowd Default").GetComponent<AudioSource>();
            CrowdGoal = _sounds.transform.Find("Crowd Goal").GetComponent<AudioSource>();
            Whistle = _sounds.transform.Find("Whistle").GetComponent<AudioSource>();
            KickBall = _sounds.transform.Find("Kick Ball").GetComponent<AudioSource>();
            HitPost = _sounds.transform.Find("Hit Post").GetComponent<AudioSource>();
            HitFense = _sounds.transform.Find("Hit Fense").GetComponent<AudioSource>();
            BounceBall = _sounds.transform.Find("Bounce Ball").GetComponent<AudioSource>();
            GoalNet = _sounds.transform.Find("Goal Net").GetComponent<AudioSource>();
            EndWhistle = _sounds.transform.Find("End Whistle").GetComponent<AudioSource>();
        }
        // 로비
        else
        {

        }
    }
}
