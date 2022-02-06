import {
  Count,
  CountSchema,
  Filter,
  FilterExcludingWhere,
  repository,
  Where,
} from '@loopback/repository';
import {
  post,
  param,
  get,
  getModelSchemaRef,
  patch,
  put,
  del,
  requestBody,
  response,
} from '@loopback/rest';
import {Gym} from '../models';
import {GymRepository} from '../repositories';

export class GymController {
  constructor(
    @repository(GymRepository)
    public gymRepository : GymRepository,
  ) {}

  @post('/gyms')
  @response(200, {
    description: 'Gym model instance',
    content: {'application/json': {schema: getModelSchemaRef(Gym)}},
  })
  async create(
    @requestBody({
      content: {
        'application/json': {
          schema: getModelSchemaRef(Gym, {
            title: 'NewGym',
            exclude: ['ID'],
          }),
        },
      },
    })
    gym: Omit<Gym, 'id'>,
  ): Promise<Gym> {
    return this.gymRepository.create(gym);
  }

  @get('/gyms/count')
  @response(200, {
    description: 'Gym model count',
    content: {'application/json': {schema: CountSchema}},
  })
  async count(
    @param.where(Gym) where?: Where<Gym>,
  ): Promise<Count> {
    return this.gymRepository.count(where);
  }

  @get('/gyms')
  @response(200, {
    description: 'Array of Gym model instances',
    content: {
      'application/json': {
        schema: {
          type: 'array',
          items: getModelSchemaRef(Gym, {includeRelations: true}),
        },
      },
    },
  })
  async find(
    @param.filter(Gym) filter?: Filter<Gym>,
  ): Promise<Gym[]> {
    return this.gymRepository.find(filter);
  }

  @patch('/gyms')
  @response(200, {
    description: 'Gym PATCH success count',
    content: {'application/json': {schema: CountSchema}},
  })
  async updateAll(
    @requestBody({
      content: {
        'application/json': {
          schema: getModelSchemaRef(Gym, {partial: true}),
        },
      },
    })
    gym: Gym,
    @param.where(Gym) where?: Where<Gym>,
  ): Promise<Count> {
    return this.gymRepository.updateAll(gym, where);
  }

  @get('/gyms/{id}')
  @response(200, {
    description: 'Gym model instance',
    content: {
      'application/json': {
        schema: getModelSchemaRef(Gym, {includeRelations: true}),
      },
    },
  })
  async findById(
    @param.path.number('id') id: number,
    @param.filter(Gym, {exclude: 'where'}) filter?: FilterExcludingWhere<Gym>
  ): Promise<Gym> {
    return this.gymRepository.findById(id, filter);
  }

  @patch('/gyms/{id}')
  @response(204, {
    description: 'Gym PATCH success',
  })
  async updateById(
    @param.path.number('id') id: number,
    @requestBody({
      content: {
        'application/json': {
          schema: getModelSchemaRef(Gym, {partial: true}),
        },
      },
    })
    gym: Gym,
  ): Promise<void> {
    await this.gymRepository.updateById(id, gym);
  }

  @put('/gyms/{id}')
  @response(204, {
    description: 'Gym PUT success',
  })
  async replaceById(
    @param.path.number('id') id: number,
    @requestBody() gym: Gym,
  ): Promise<void> {
    await this.gymRepository.replaceById(id, gym);
  }

  @del('/gyms/{id}')
  @response(204, {
    description: 'Gym DELETE success',
  })
  async deleteById(@param.path.number('id') id: number): Promise<void> {
    await this.gymRepository.deleteById(id);
  }
}
