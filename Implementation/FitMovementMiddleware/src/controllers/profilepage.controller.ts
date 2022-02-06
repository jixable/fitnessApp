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
import {Profilepage} from '../models';
import {ProfilepageRepository} from '../repositories';

export class ProfilepageController {
  constructor(
    @repository(ProfilepageRepository)
    public profilepageRepository : ProfilepageRepository,
  ) {}

  @post('/profilepages')
  @response(200, {
    description: 'Profilepage model instance',
    content: {'application/json': {schema: getModelSchemaRef(Profilepage)}},
  })
  async create(
    @requestBody({
      content: {
        'application/json': {
          schema: getModelSchemaRef(Profilepage, {
            title: 'NewProfilepage',
            
          }),
        },
      },
    })
    profilepage: Profilepage,
  ): Promise<Profilepage> {
    return this.profilepageRepository.create(profilepage);
  }

  @get('/profilepages/count')
  @response(200, {
    description: 'Profilepage model count',
    content: {'application/json': {schema: CountSchema}},
  })
  async count(
    @param.where(Profilepage) where?: Where<Profilepage>,
  ): Promise<Count> {
    return this.profilepageRepository.count(where);
  }

  @get('/profilepages')
  @response(200, {
    description: 'Array of Profilepage model instances',
    content: {
      'application/json': {
        schema: {
          type: 'array',
          items: getModelSchemaRef(Profilepage, {includeRelations: true}),
        },
      },
    },
  })
  async find(
    @param.filter(Profilepage) filter?: Filter<Profilepage>,
  ): Promise<Profilepage[]> {
    return this.profilepageRepository.find(filter);
  }

  @patch('/profilepages')
  @response(200, {
    description: 'Profilepage PATCH success count',
    content: {'application/json': {schema: CountSchema}},
  })
  async updateAll(
    @requestBody({
      content: {
        'application/json': {
          schema: getModelSchemaRef(Profilepage, {partial: true}),
        },
      },
    })
    profilepage: Profilepage,
    @param.where(Profilepage) where?: Where<Profilepage>,
  ): Promise<Count> {
    return this.profilepageRepository.updateAll(profilepage, where);
  }

  @get('/profilepages/{id}')
  @response(200, {
    description: 'Profilepage model instance',
    content: {
      'application/json': {
        schema: getModelSchemaRef(Profilepage, {includeRelations: true}),
      },
    },
  })
  async findById(
    @param.path.string('id') id: string,
    @param.filter(Profilepage, {exclude: 'where'}) filter?: FilterExcludingWhere<Profilepage>
  ): Promise<Profilepage> {
    return this.profilepageRepository.findById(id, filter);
  }

  @patch('/profilepages/{id}')
  @response(204, {
    description: 'Profilepage PATCH success',
  })
  async updateById(
    @param.path.string('id') id: string,
    @requestBody({
      content: {
        'application/json': {
          schema: getModelSchemaRef(Profilepage, {partial: true}),
        },
      },
    })
    profilepage: Profilepage,
  ): Promise<void> {
    await this.profilepageRepository.updateById(id, profilepage);
  }

  @put('/profilepages/{id}')
  @response(204, {
    description: 'Profilepage PUT success',
  })
  async replaceById(
    @param.path.string('id') id: string,
    @requestBody() profilepage: Profilepage,
  ): Promise<void> {
    await this.profilepageRepository.replaceById(id, profilepage);
  }

  @del('/profilepages/{id}')
  @response(204, {
    description: 'Profilepage DELETE success',
  })
  async deleteById(@param.path.string('id') id: string): Promise<void> {
    await this.profilepageRepository.deleteById(id);
  }
  
  @put('/profilepage/postpicturehash')
  @response(204, {
    description: 'Profilepage PUT success',
  })
  async post_pichash(
    @requestBody({
      content: {
        'application/json': {
          schema: getModelSchemaRef(Profilepage, {
            // title: 'We posting up in here',
          }),
        },
      },
    }) profilepage : Omit<Profilepage, 'PICTURE_HASH'>
  ): Promise<void> {
    return this.profilepageRepository.replaceById(profilepage.USERNAME, profilepage);
  }

  @post('/profilepages/getpicturehash')
  @response(200, {
    description: 'A specific hashed pic',
    content: {
      'application/json': {
        response: 'string'
      },
    },
  })
  async find_picture(
      @requestBody({
      content: {
        'application/json': {
          schema: getModelSchemaRef(Profilepage, {
          }),
        },
      },
    })
    profilepage: Profilepage
  ): Promise<String> {
    return "" + (await this.profilepageRepository.findById(profilepage.USERNAME)).PICTURE_HASH;
  }
}