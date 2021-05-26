extends KinematicBody2D

# The functionality of this class is to define the movement of the 'Player'.
# In addition, defines the the roll and attack states of the 'Player'.

const PlayerHurtSound = preload("res://Player/PlayerHurtSound.tscn")

# This makes it possible so the number can be changed while debugging.
# Export variable allow me to change the health in the editor instead for code.

# 'ACCELERATION' - How quickly the 'Player' moves to a location.
# 'MAX_SPEED' - The max speed the player will be allowed to travel.
# 'ROLL_SPEED' - Speed at which the player can dodge.
# 'FRICTION' - What slows the player.

export var ACCELERATION = 500
export var MAX_SPEED = 80
export var ROLL_SPEED = 120
export var FRICTION = 500

# Starts 'switch' like operation aka State machine.
# enum - A keyword used in gdscript for making a bunch of related constants.
enum {
	MOVE,
	ROLL,
	ATTACK,
}

# 'Vector2' is used for 2D math.
var state = MOVE
var velocity = Vector2.ZERO
var roll_vector = Vector2.DOWN
var stats = PlayerStats # A singleton is being called here, these are similar 
						# too globals but can oly be instanced once.

# Function that become inherited to this class
onready var animationPlayer = $AnimationPlayer
onready var animationTree = $AnimationTree
onready var animationState = animationTree.get("parameters/playback")
onready var swordHitbox = $HitBoxPivot/SwordHitBox
onready var hurtbox = $HurtBox
onready var blinkAnimationPlayer = $BlinkAnimationPlayer

# The '_ready()' function is called when the node, and all its children, enters 
# the active scene. - Not a constructor.
func _ready():
	randomize()
	# Connects the stats to the rest of the objects inside 'Player'.
	# Moreover if the player has no_health then the player is freed
	stats.connect("no_health", self, "queue_free")
	animationTree.active = true
	swordHitbox.knockback_vector = roll_vector

# The following function overrides the processes for the changes the 'Player'
# can take.
func _physics_process(delta):
	# Works as a switch statement, but works as an abstarct class 
	# too as the code is being written on another line.
	match state:
		MOVE:
			move_state(delta)
		ROLL:
			roll_state(delta)
		ATTACK:
			attack_state(delta)


func move_state(delta):
	var input_vector = Vector2.ZERO
	input_vector.x = Input.get_action_strength("ui_right") - Input.get_action_strength("ui_left")
	input_vector.y = Input.get_action_strength("ui_down") - Input.get_action_strength("ui_up")
	input_vector = input_vector.normalized()
	
	# This is where the animation is placed so that it matches the movement
	# Input vectoe is found in the animation player, and it detects which
	# vertice your are moving torward. This calls from the 'AnimationTree'
	if input_vector != Vector2.ZERO:
		roll_vector = input_vector
		swordHitbox.knockback_vector = input_vector
		animationTree.set("parameters/Idle/blend_position", input_vector)
		animationTree.set("parameters/Run/blend_position", input_vector)
		animationTree.set("parameters/Attack/blend_position", input_vector)
		animationTree.set("parameters/Roll/blend_position", input_vector)
		animationState.travel("Run")
		velocity = velocity.move_toward(input_vector * MAX_SPEED, ACCELERATION * delta)
	else:
		animationState.travel("Idle")
		velocity = velocity.move_toward(Vector2.ZERO, FRICTION * delta)

	move()
	
	if Input.is_action_just_pressed("Roll"):
		state = ROLL
	
	if Input.is_action_just_pressed("attack"):
		state = ATTACK

# The velocity for traveling on roll is changed to go in the direction of 
# the movement the player took last. The plays the animation.
func roll_state(_delta):
	velocity = roll_vector * ROLL_SPEED
	animationState.travel("Roll")
	move()
	
func move():
	velocity = move_and_slide(velocity)

# Here I'm overriding the usual delta function that is integrated to the
# 'KinematicBody2D'
func attack_state(_delta):
	velocity = Vector2.ZERO
	animationState.travel("Attack")

# This slows the players speed as to not attack while moving
func attack_animation_finished():
	velocity = velocity * 0.8
	state = MOVE
	
func roll_animation_finished():
	state = MOVE

# Cause the charater to take damage

func _on_HurtBox_area_entered(area):
	stats.health -= area.damage
	hurtbox.start_invincibilty(0.6)
	hurtbox.create_hit_effect()
	var playerHurtSound = PlayerHurtSound.instance()
	get_tree().current_scene.add_child(playerHurtSound)

# This causes the character to blink in white when hit and invincibilty starts

func _on_HurtBox_invincibility_started():
	blinkAnimationPlayer.play("Start")

func _on_HurtBox_invincibility_ended():
	blinkAnimationPlayer.play("Stop")
