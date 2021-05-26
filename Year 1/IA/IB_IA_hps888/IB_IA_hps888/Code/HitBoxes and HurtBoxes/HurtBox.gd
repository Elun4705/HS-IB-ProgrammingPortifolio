extends Area2D

# The function of this class is to give the hurtbox an invincibility activation
# connecting to either the Bat, Talus, and the Player

const HitEffect = preload("res://Effects/HitEffect.tscn")

var invincible = false setget set_invincible

# Calls forth the Timer and CollisionShape2D for the invincibility
onready var timer = $Timer
onready var collisionShape = $CollisionShape2D

signal invincibility_started
signal invincibility_ended

# Sends signal out to the parent class that inherits this class
func set_invincible(value):
	invincible = value
	if invincible == true:
		emit_signal("invincibility_started")
	else:
		emit_signal("invincibility_ended")

# Set invincible to true, which starts the timer. 
# Once done sets back to false - Creates new signals 
# Duration is theset amount of time for the invincivility
func start_invincibilty(duration):
	self.invincible = true
	timer.start(duration)

func create_hit_effect():
	var effect = HitEffect.instance()
	# Instead of calling the parent like before, I switched the code
	# so as to be less confusing.
	var main = get_tree().current_scene
	main.add_child(effect)
	effect.global_position = global_position

# Sets invincibility to false
func _on_Timer_timeout():
	self.invincible = false

# Checks for which collision to look out for(repeatedly)

func _on_HurtBox_invincibility_ended():
	collisionShape.disabled = false

func _on_HurtBox_invincibility_started():
	collisionShape.set_deferred("disabled", true)
