package net.lunarluned.peculia.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

public class GravestoneBlock extends Block {
    public static final DirectionProperty FACING;
    public static final VoxelShape SHAPE_WEST;
    public static final VoxelShape SHAPE_NORTH;
    public static final VoxelShape SHAPE_EAST;
    public static final VoxelShape SHAPE_SOUTH;
    private static final VoxelShape SHAPE = Shapes.or(Block.box(6.0D, 0.0D, 2.0D, 10.0D, 14.0D, 14.0D));

    public GravestoneBlock(Properties properties) {
        super(properties);
    }

    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        return this.defaultBlockState().setValue(FACING, ctx.getHorizontalDirection().getClockWise());
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{FACING});
    }

    public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        switch (blockState.getValue(FACING)) {
            case NORTH:
                return SHAPE_NORTH;
            case SOUTH:
                return SHAPE_SOUTH;
            case EAST:
                return SHAPE_EAST;
            case WEST:
                return SHAPE_WEST;
            default:
                return SHAPE;
        }
    }

    static {
        FACING = HorizontalDirectionalBlock.FACING;
        SHAPE_EAST = Shapes.or(Block.box(2.0D, 0.0D, 6.0D, 14.0D, 14.0D, 10.0D));
        SHAPE_WEST = Shapes.or(Block.box(2.0D, 0.0D, 6.0D, 14.0D, 14.0D, 10.0D));
        SHAPE_NORTH = Shapes.or(Block.box(6.0D, 0.0D, 2.0D, 10.0D, 14.0D, 14.0D));
        SHAPE_SOUTH = Shapes.or(Block.box(6.0D, 0.0D, 2.0D, 10.0D, 14.0D, 14.0D));
    }

}
