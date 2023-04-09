package ru.kram.galaxion.core.base

abstract class Enemy: PlaygroundObject() {

    protected abstract var damage: Int
    protected abstract var speed: Speed
    protected abstract var hp: Int
    protected abstract var direction: Int
}