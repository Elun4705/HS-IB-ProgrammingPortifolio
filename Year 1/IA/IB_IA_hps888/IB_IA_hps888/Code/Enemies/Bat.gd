extends KinematicBody2D

const FaintEffect = preload("res://Effects/FaintEffect.tscn")

# The functionality of the class is to give the Bat it's own IA.
# It can be 'IDLE', 'WANDER', or give 'CHASE' to the player

# 'ACCELERATION' - How quickly the 'Player' moves to a location.
# 'MAX_SPEED' - The max speed the player will be allowed to travel.
# 'ROLL_SPEED' - Speed at which the player can dodge.
# 'FRICTION' - What slows the player.

# This makes it possible so the number can be changed while debugging.
# Export variable allow me to change the health in the editor instead for code.

export var ACCELERATION = 300
export var MAX_SPEED = 50
export var FRICTION = 200
export var WANDEER_TARGET_RANGE = 4

# Starts 'switch' like operation aka State machine.
# A keyword used in gdscript for making a bunch of related constants.
# Simlar to that of 'Player.gd'. There are related as they are the
# actions of the bat.
# Simlar to that of 'Player.gd'.


enum {
	IDLE,
	WANDER,
	CHASE,
}

# Velocity and knockback are declare with the Vector2/2D Math
var velocity = Vector2.ZERO
var knockback = Vector2.ZERO

onready var damage = HitBox

var state = CHASE

# An onready var is assigned a value after 
# the node and its siblings entered the tree.
# In this case, as sson as it exists in the tree.

onready var sprite = $AnimatedSprite
onready var stats = $Stats
onready var playerDetectionZone = $PlayerDetectionZone
onready var hurtBox = $HurtBox
onready var softCollision = $SoftCollision
onready var wanderController = $WanderController
onready var animationPlayer = $AnimationPlayer

# The _ready() function is called when the node, and all its children, enters 
# the active scene. - Not a constructor.

func _ready():
	state = pick_random_state([IDLE, WANDER])

func _physics_process(delta):
	knockback = knockback.move_toward(Vector2.ZERO, 200 * delta)
	knockback = move_and_slide(knockback)


	# Instead of creating a state machine within the player's control script, 
	# development is much simpler if the states were separated out into 
	# different sections of being.

	match state:
		IDLE:
			velocity = velocity.move_toward(Vector2.ZERO, FRICTION * delta)
			seek_player()
			if wanderController.get_time_left() == 0:
				# An array here will be used to randomly pick a state.
				update_wander()

		WANDER:
			# Visuality seems as though the bat is wondering
			# Get random position, travels to it, stops, and travels back to
			# the point of origin via 'target_position'
			seek_player()
			if wanderController.get_time_left() == 0:
				update_wander()
			accelerate_torwards_point(wanderController.target_position, delta)
			if global_position.distance_to(wanderController.target_position) <= WANDEER_TARGET_RANGE:
				update_wander()

		CHASE:
			# Gets the global position of the player and follows the player.
			var player = playerDetectionZone.player
			if player != null:
				accelerate_torwards_point(player.global_position, delta)
			else:
				state = IDLE

	# Pushes the bats in opposite directions when they collide, but with little
	# force
	if softCollision.is_colliding():
		velocity += softCollision.get_push_vector() * delta * 400
	velocity = move_and_slide(velocity)

# An array here will be used to randomly pick a state
func update_wander():
	state = pick_random_state([IDLE, WANDER])
	wanderController.start_wander_timer(rand_range(1, 3))

# Take the XY of Player - XY of Bat - normalized makes the distance 
# one so that it can be muliplied by the speed and acceleration
func accelerate_torwards_point(point, delta):
	var direction = global_position.direction_to(point)
	velocity = velocity.move_toward(direction * MAX_SPEED, ACCELERATION * delta)
	# sprite.flip_h flips the bat sprite so it faces the player/rightside
	sprite.flip_h = velocity.x < 0

# If the player is detected, the bat will give chase
func seek_player():
	if playerDetectionZone.can_see_player():
		state = CHASE

func pick_random_state(state_list):
	state_list.shuffle()
	return state_list.pop_front()

# How the Bat takes damage. This is different to the player and idetical to the
# talus, as to give the player an upper hand on the enemies.
func _on_HurtBox_area_entered(area):
	stats.health -= damage.damage
	knockback = area.knockback_vector * 120
	hurtBox.create_hit_effect()
	hurtBox.start_invincibilty(0.4)

# Frees the Bat Scene, it visually deletes it.
func _on_Stats_no_health():
	queue_free()
	var faintEffect = FaintEffect.instance()
	get_parent().add_child(faintEffect)
	faintEffect.global_position = global_position

# This causes the character to blink in white when hit and invincibilty starts

func _on_HurtBox_invincibility_started():
	animationPlayer.play("Start")

func _on_HurtBox_invincibility_ended():
	animationPlayer.play("Stop")
